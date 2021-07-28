package com.gui;

import com.plotter.Plot;
import com.plotter.Range;
import com.plotter.RangeListener;
import javax.swing.*;


public class Canvas extends JComponent {

    protected final Plot plot;
    protected final Range range;

    /**
     * Create a new src.main.java.com.gui.ShadeCanvas presenting the given src.main.java.com.plotter.Plot.
     *
     * @param plot The src.main.java.com.plotter.Plot to render
     */
    public Canvas(final Plot plot) {
        super();
        this.plot = plot;
        this.range = plot.getRange();

        addFunctionRangeListeners();
    }

    private void addFunctionRangeListeners() {
        range.addRangeListener(new RangeListener() {
            public void rangeChanged(final Range range) {
                repaint();
            }
        });
    }

}
