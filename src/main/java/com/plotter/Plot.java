package src.main.java.com.plotter;

import java.util.ArrayList;

/**
 * The src.main.java.com.plotter.Plot is the "model" of this application.
 * It is an immutable class that
 * points to the two mutable and observable parts of the "model":
 * 1) a src.main.java.com.plotter.Function, and
 * 2) a src.main.java.com.plotter.Range (along the x-axis, over which the function should be plotted).
 */
public final class Plot {

    private final ArrayList<Function> functionList;
    private final ArrayList<PlotListener> listeners;
    private final Range range;
    private final Cursor cursor;
    
    
    /**
     * Create a new src.main.java.com.plotter.Plot of the given src.main.java.com.plotter.Function, with the given src.main.java.com.plotter.Range and src.main.java.com.plotter.Cursor.
     * @param range The src.main.java.com.plotter.Range (on the x-axis) over which to plot
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
     * Adds a function in the plot. It attaches an src.main.java.com.plotter.FunctionListener for each of them.
     * @param func a src.main.java.com.plotter.Function.
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
     * Remove a src.main.java.com.plotter.Function from the function list.
     * @param func a src.main.java.com.plotter.Function.
     */
    public void removeFunction(final Function func) {
        functionList.remove(func);
    }

    /**
     * Get function at an index.
     * @param index the index.
     * @return the function at a given index.
     */
    public Function getFunction(final int index) {
        return functionList.get(index);
    }

    /**
     * Get the src.main.java.com.plotter.Function of this src.main.java.com.plotter.Plot.
     * @return this src.main.java.com.plotter.Plot's src.main.java.com.plotter.Function
     */
    public final ArrayList<Function> getFunctionList() {
        return functionList;
    }

    /**
     * Get the src.main.java.com.plotter.Range of this src.main.java.com.plotter.Plot.
     * @return this src.main.java.com.plotter.Plot's src.main.java.com.plotter.Range
     */
    public final Range getRange() {
        return range;
    }
    
    /**
     * Get the src.main.java.com.plotter.Cursor of this src.main.java.com.plotter.Plot.
     * @return this src.main.java.com.plotter.Plot's src.main.java.com.plotter.Cursor
     */
    public final Cursor getCursor() {
        return cursor;
    }

    /**
     * Adds a listener
     * @param li A src.main.java.com.plotter.PlotListener.
     */
    public final void addListener(final PlotListener li) {
        listeners.add(li);
    }

    /**
     * Remove a listener
     * @param li a src.main.java.com.plotter.PlotListener.
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
