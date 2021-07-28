package src.main.java.com.plotter;

/**
 * The "model" doesn't know the specific "GUI" classes.
 * But it still wants to notify the "GUI" (or text UI, or ...)
 * whenever the "model" changes, so that the "GUI" (or text UI, or ...)
 * can react to those changes (e.g., by repainting itself).
 * 
 * <p>To enable this, we have this src.main.java.com.plotter.CursorListener interface.
 * The "model" (i.e., the src.main.java.com.plotter.Cursor) will call cursorChanged()
 * on all registered listeners,
 * without knowing the specific subtype of src.main.java.com.plotter.CursorListener
 * (e.g., the "model" does not know about the src.main.java.com.gui.PlotCanvas class).
 */
public interface CursorListener {

    /**
     * Notify this src.main.java.com.plotter.CursorListener that the given src.main.java.com.plotter.Cursor has changed.
     * @param cursor The src.main.java.com.plotter.Cursor that changed.
     */
    public abstract void cursorChanged(Cursor cursor);

}
