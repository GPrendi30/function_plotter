package com.gui;

import com.plotter.Cursor;
import com.plotter.CursorListener;
import com.plotter.Function;
import com.plotter.Plot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


/**
 * The src.main.java.com.gui.PlotCanvas is part of the GUI.
 * It is a custom component, which draws itself
 * (in the paintComponent method)
 * and which provides information on how big it would like to be
 * (via the getPreferredSize method).
 */
public final class PlotCanvas extends Canvas {

    private static final Dimension PREFERRED_SIZE = new Dimension(400, 300);
    private final Cursor cursor;
    private final Color[] colors = {
        Color.BLUE,
        Color.GREEN,
        Color.RED,
        Color.CYAN,
        Color.PINK,
        Color.MAGENTA,
        Color.ORANGE,};


    /**
     * Create a src.main.java.com.gui.PlotCanvas for the given src.main.java.com.plotter.Plot.
     *
     * @param plot The src.main.java.com.plotter.Plot to show
     */
    public PlotCanvas(final Plot plot) {
        super(plot);
        this.cursor = plot.getCursor();
        // register listeners        
        cursor.addCursorListener(new CursorListener() {
            public void cursorChanged(final Cursor cursor) {
                repaint();
            }
        });
        addMouseListener(new MouseAdapter() {
            public void mousePressed(final MouseEvent ev) {
                cursor.setX(xViewToModel(ev.getX()));
                cursor.setY(ev.getY());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(final MouseEvent ev) {
                cursor.setX(xViewToModel(ev.getX()));
                cursor.setY(ev.getY());
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }

    @Override
    public void paintComponent(final Graphics g) {
        // fill the background with white
        final Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // find min and max model y
        final double minModelY = range.getMin();
        final double maxModelY = range.getMax();

        drawAxes(g2d, minModelY, maxModelY);

        // plot curve
        drawFunction(g2d, minModelY, maxModelY);

        // draw x and y cursor
        drawCursors(g, minModelY, maxModelY);
    }


    private void drawFunction(final Graphics g, final double minModelY, final double maxModelY) {
        int i = 0;
        for (final Function function : plot.getFunctionList()) {
            i++;
            if (!function.isDrawable()) {
                continue;
            }

            g.setColor(colors[i]);


            final Graphics2D g2d = (Graphics2D) g;
            int prevX = 0;
            int prevY = 0;
            for (int vx = xModelToView(function.getRange().getMin());
                 vx <= xModelToView(function.getRange().getMax());
                 vx++) {

                final double xModel = xViewToModel(vx);
                final double yModel = function.compute(xModel);
                final int vy = yModelToView(yModel, minModelY, maxModelY);

                if (vx == xModelToView(function.getRange().getMin())) {
                    prevX = vx;
                    prevY = vy;
                }

                g2d.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawLine(prevX, prevY, vx, vy);

                prevX = vx;
                prevY = vy;
            }
        }
    }

    private void drawAxes(final Graphics g, final double minModelY, final double maxModelY) {
        final Graphics2D g2d = (Graphics2D) g.create();
        final int viewY0 = yModelToView(0, minModelY, maxModelY);
        final int viewX0 = xModelToView(0);
        drawHorizontal(g2d, minModelY, maxModelY);
        drawVertical(g2d, minModelY, maxModelY);
        g2d.setColor(Color.BLACK);

        g2d.drawLine(0, viewY0, getWidth(), viewY0);

        g2d.drawLine(viewX0, 0, viewX0, getHeight());
    }

    private void drawVertical(final Graphics2D g2d,
                              final double maxModelY,
                              final double minModelY) {

        final int stepsize = 20;
        final String numFormat = "%.2f";

        double Xneg = 0;
        double Xpos = 0;

        final double numsquaresY = getWidth() / 20;
        final double numstepY = (maxModelY - minModelY) / numsquaresY;

        final int viewY0 = yModelToView(0, minModelY, maxModelY);
        final int viewX0 = xModelToView(0);

        int positiveY = viewX0;
        int negativeY = viewX0;

        int count = 0;
        for (int i = 0; i < getHeight(); i++) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine(positiveY, 0, positiveY, getHeight());
            g2d.drawLine(negativeY, 0, negativeY, getHeight());

            if (count == 4) {
                g2d.setColor(Color.DARK_GRAY);
                g2d.drawString("" + String.format(numFormat, Xpos),
                        (float) positiveY,
                        (float) viewY0);
                g2d.drawString("" + String.format(numFormat, Xneg),
                        (float) negativeY,
                        (float) viewY0);
                count = 0;
            }
            positiveY += stepsize;
            negativeY -= stepsize;

            Xpos += numstepY;
            Xneg -= numstepY;

            Xpos = Xpos > 5
                    ? Math.round(Xpos / 5) * 5
                    : Xpos;
            Xneg = Xneg < -5
                    ? Math.round(Xneg / 5) * 5
                    : Xneg;
            count++;
        }
    }

    private void drawHorizontal(final Graphics2D g2d,
                                final double maxModelY,
                                final double minModelY) {

        final int stepsize = 20;
        final String numFormat = "%.2f";

        double Yneg = 0;
        double Ypos = 0;

        final int viewY0 = yModelToView(0, minModelY, maxModelY);
        final int viewX0 = xModelToView(0);

        int positiveX = viewY0;
        int negativeX = viewY0;

        final double numsquaresX = getHeight() / 20;
        final double numstepX = (maxModelY - minModelY) / numsquaresX;

        int count = 0;
        for (int i = 0; i < getWidth(); i++) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine(0, positiveX, getWidth(), positiveX);
            g2d.drawLine(0, negativeX, getWidth(), negativeX);

            if (count == 4) {
                g2d.setColor(Color.DARK_GRAY);
                g2d.drawString("" + String.format(numFormat, Ypos),
                        (float) viewX0 - 30,
                        (float) positiveX);
                g2d.drawString("" + String.format(numFormat, Yneg),
                        (float) viewX0 - 30,
                        (float) negativeX);
                count = 0;
            }
            positiveX += stepsize;
            negativeX -= stepsize;

            Ypos -= numstepX;
            Yneg += numstepX;

            Ypos = Ypos <= -5
                    ? Math.round(Ypos / 5) * 5
                    : Ypos;

            Yneg = Yneg >= 5
                    ? Math.round(Yneg / 5) * 5
                    : Yneg;
            count++;
        }
        g2d.setColor(Color.BLACK);
        g2d.drawString("" + 0,
                (float) viewX0 - 10,
                (float) viewY0 + 15);
    }

    private void drawCursors(final Graphics g, final double minModelY, final double maxModelY) {
        g.setColor(Color.BLACK);
        final int cursorViewX = xModelToView(cursor.getX());
        final int cursorViewY = (int) cursor.getY();
        g.drawLine(cursorViewX, 0, cursorViewX, getHeight());

        g.drawString("x = " + cursor.getX(), cursorViewX + 4, getHeight() - 20);
        // draw y cursor
        final int viewY0 = yModelToView(0, minModelY, maxModelY);
        g.drawLine(0, cursorViewY, getWidth(), cursorViewY);
        g.drawString("y = " + 2 * (-cursorViewY + viewY0), cursorViewX + 4, getHeight() - 4);
    }

    private double xViewToModel(final int vx) {
        return ((double) vx) / getWidth() * range.getExtent() + range.getMin();
    }

    private int xModelToView(final double x) {
        return (int) ((x - range.getMin()) / range.getExtent() * getWidth());

    }

    private int yModelToView(final double y, final double minY, final double maxY) {
        return (int) (getHeight() - 1 - (y - minY) / (maxY - minY) * getHeight());
    }

    /**
     * Zoom in the view(actually decreases the range).
     */
    public void zoomIn() {
        //scale += 1.5;
        final double min = plot.getRange().getMin();
        final double max = plot.getRange().getMax();
        plot.getRange().setMin(min / 1.5);
        plot.getRange().setMax(max / 1.5);
    }

    /**
     * Zoom out the view(it actually increases the range).
     */
    public void zoomOut() {
        //scale -= 1.5;
        final double min = plot.getRange().getMin();
        final double max = plot.getRange().getMax();
        plot.getRange().setMin(min * 1.5);
        plot.getRange().setMax(max * 1.5);
    }
}