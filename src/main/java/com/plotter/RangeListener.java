package com.plotter;

/**
 * The "model" doesn't know the specific "GUI" classes.
 * But it still wants to notify the "GUI" (or text UI, or ...)
 * whenever the "model" changes, so that the "GUI" (or text UI, or ...)
 * can react to those changes (e.g., by repainting itself).
 *
 * <p>To enable this, we have this RangeListener interface.
 * The "model" (i.e., the Range) will call rangeChanged()
 * on all registered listeners,
 * without knowing the specific subtype of RangeListener
 * (e.g., the "model" does not know about the PlotCanvas class).
 */
public interface RangeListener {

    /**
     * Notify this RangeListener that the given com.plotter.Range has changed.
     *
     * @param range The com.plotter.Range that changed.
     */
    void rangeChanged(Range range);

}
