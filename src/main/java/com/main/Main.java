package com.main;

import java.awt.EventQueue;
import com.gui.PlotterFrame;
import com.plotter.Cursor;
import com.plotter.Plot;
import com.plotter.Range;


/**
 * The class containing the application's main() method.
 */
public final class Main {

    private Main() {
    }

    /**
     * Create the model (a src.main.java.com.plotter.Plot),
     * and then create the GUI (a src.main.java.com.gui.PlotterFrame).
     * The GUI is created in the event dispatch tread.
     * @param args Command line arguments (unused)
     */
    public static void main(final String[] args) {
        final Plot plot = new Plot(new Range(-1000, 1000), new Cursor(0));

        // Almost all calls to AWT/Swing should come from Event Dispach Thread.
        // The code below causes the Event Dispatch Thread to call the run function,
        // which creates the GUI.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Create the GUI, passing in the model
                // (GUI knows model, model does not know GUI)
                final PlotterFrame frame = new PlotterFrame(plot);
                // making the frame visible causes the event dispatching
                // (handling of mouse and keyboard events) to start
                frame.setVisible(true);
            }
        });
    }

}
