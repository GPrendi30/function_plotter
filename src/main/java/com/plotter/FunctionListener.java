package com.plotter;

/**
 * The "model" doesn't know the specific "GUI" classes.
 * But it still wants to notify the "GUI" (or text UI, or ...)
 * whenever the "model" changes, so that the "GUI" (or text UI, or ...)
 * can react to those changes (e.g., by repainting itself).
 *
 * <p>To enable this, we have this src.main.java.com.plotter.FunctionListener interface.
 * The "model" (i.e., the src.main.java.com.plotter.Function) will call functionChanged()
 * on all registered listeners,
 * without knowing the specific subtype of src.main.java.com.plotter.FunctionListener
 * (e.g., the "model" does not know about the src.main.java.com.gui.PlotCanvas class).
 */
public interface FunctionListener {

    /**
     * React to a modification of the given src.main.java.com.plotter.Function.
     *
     * @param function the src.main.java.com.plotter.Function that changed
     */
    void functionChanged(Function function);

}
