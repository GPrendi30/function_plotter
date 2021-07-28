package com.plotter;

/**
 * The "model" doesn't know the specific "GUI" classes.
 * But it still wants to notify the "GUI" (or text UI, or ...)
 * whenever the "model" changes, so that the "GUI" (or text UI, or ...)
 * can react to those changes (e.g., by repainting itself).
 *
 * <p>To enable this, we have this CursorListener interface.
 * The "model" (i.e., the Cursor) will call cursorChanged()
 * on all registered listeners,
 * without knowing the specific subtype of CursorListener
 * (e.g., the "model" does not know about the PlotCanvas class).
 */
public interface CursorListener {

    /**
     * Notify this CursorListener that the given Cursor has changed.
     *
     * @param cursor The Cursor that changed.
     */
    void cursorChanged(Cursor cursor);

}
