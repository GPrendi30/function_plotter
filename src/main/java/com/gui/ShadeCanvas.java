package com.gui;

import com.plotter.Plot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


/**
 * The src.main.java.com.gui.ShadeCanvas is part of the GUI.
 * It is a custom component, which draws itself
 * (in the paintComponent method)
 * and which provides information on how big it would like to be
 * (via the getPreferredSize method).
 */
public final class ShadeCanvas extends Canvas {

    private static final Dimension PREFERRED_SIZE = new Dimension(400, 20);


    /**
     * Create a new ShadeCanvas presenting the given Plot.
     *
     * @param plot The Plot to render
     */
    public ShadeCanvas(final Plot plot) {
        super(plot);
    }

    @Override
    public final Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }

    @Override
    public final void paintComponent(final Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        final Double minModelY = range.getMin();
        final Double maxModelY = range.getMax();

        for (int vx = 0; vx < getWidth(); vx++) {

            final double xModel = xViewToModel(vx);
            final double yModel = plot.getFunction(0).compute(xModel);
            final int vy = yModelToView(yModel, minModelY, maxModelY);

            int greyValue;
            // keeping the range from 0 to 255
            if (vy < 0) {
                greyValue = 0;
            } else if (vy >= 255) {
                greyValue = 255;
            } else {
                greyValue = vy;
            }

            // inversing the colors.
            greyValue = 255 - greyValue;
            final Color c = new Color(greyValue, greyValue, greyValue);

            g.setColor(c);
            g.drawLine(vx, 0, vx, getHeight());
        }

    }

    /**
     * Convert the given view x-coordinate into a model coordinate.
     *
     * @param vx an x-coordinate in the view (pixels from left of canvas)
     * @return x-coordinate in the model
     */
    private double xViewToModel(final int vx) {
        return ((double) vx) / getWidth() * range.getExtent() + range.getMin();
    }

    /**
     * Convert the given model y-coordinate into a view coordinate.
     *
     * @param y an y-coordinate in the model
     * @return y-coordinate in the view (pixels from top of canvas)
     */
    private int yModelToView(final double y, final double minY, final double maxY) {
        return (int) ((y - minY) / (maxY - minY) * 255);
    }

}