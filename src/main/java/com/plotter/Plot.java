package com.plotter;

import java.util.ArrayList;

/**
 * The src.main.java.com.plotter.Plot is the "model" of this application.
 * It is an immutable class that
 * points to the two mutable and observable parts of the "model":
 * 1) a Function, and
 * 2) a Range (along the x-axis, over which the function should be plotted).
 */
public final class Plot {

    private final ArrayList<Function> functionList;
    private final ArrayList<PlotListener> listeners;
    private final Range range;
    private final Cursor cursor;


    /**
     * Create a new Plot of the given Function, with the given Range and Cursor.
     *
     * @param range  The src.main.java.com.plotter.Range (on the x-axis) over which to plot
     * @param cursor The src.main.java.com.plotter.Cursor denoting a point on the x-axis
     */
    public Plot(final Range range, final Cursor cursor) {
        this.functionList = new ArrayList<>();
        this.range = range;
        this.cursor = cursor;
        this.listeners = new ArrayList<>();

        this.range.addRangeListener(new RangeListener() {
            @Override
            public void rangeChanged(final Range range) {
                firePlotChanged();
            }
        });
    }

    /**
     * Adds a function in the plot. It attaches an FunctionListener for each of them.
     *
     * @param func a Function.
     */
    public void addFunction(final Function func) {
        func.addFunctionListener(new FunctionListener() {
            @Override
            public void functionChanged(final Function function) {
                firePlotChanged();
            }
        });

        functionList.add(func);
    }

    /**
     * Remove a Function from the function list.
     *
     * @param func a Function.
     */
    public void removeFunction(final Function func) {
        functionList.remove(func);
    }

    /**
     * Get function at an index.
     *
     * @param index the index.
     * @return the function at a given index.
     */
    public Function getFunction(final int index) {
        return functionList.get(index);
    }

    /**
     * Get the Function of this Plot.
     *
     * @return this Plot's Function
     */
    public final ArrayList<Function> getFunctionList() {
        return functionList;
    }

    /**
     * Get the Range of this Plot.
     *
     * @return this Plot's Range
     */
    public final Range getRange() {
        return range;
    }

    /**
     * Get the Cursor of this Plot.
     *
     * @return this Plot's Cursor
     */
    public final Cursor getCursor() {
        return cursor;
    }

    /**
     * Adds a listener
     *
     * @param li A PlotListener.
     */
    public final void addListener(final PlotListener li) {
        listeners.add(li);
    }

    /**
     * Remove a listener
     *
     * @param li a PlotListener.
     */
    public final void removeListener(final PlotListener li) {
        listeners.remove(li);
    }


    private final void firePlotChanged() {
        for (final PlotListener li : listeners) {
            li.firePlotChanged(this);
        }
    }


}
