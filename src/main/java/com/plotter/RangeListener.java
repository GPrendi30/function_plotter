package src.main.java.com.plotter;

/**
 * The "model" doesn't know the specific "GUI" classes.
 * But it still wants to notify the "GUI" (or text UI, or ...)
 * whenever the "model" changes, so that the "GUI" (or text UI, or ...)
 * can react to those changes (e.g., by repainting itself).
 * 
 * <p>To enable this, we have this src.main.java.com.plotter.RangeListener interface.
 * The "model" (i.e., the src.main.java.com.plotter.Range) will call rangeChanged()
 * on all registered listeners,
 * without knowing the specific subtype of src.main.java.com.plotter.RangeListener
 * (e.g., the "model" does not know about the src.main.java.com.gui.PlotCanvas class).
 */
public interface RangeListener {

    /**
     * Notify this src.main.java.com.plotter.RangeListener that the given src.main.java.com.plotter.Range has changed.
     * @param range The src.main.java.com.plotter.Range that changed.
     */
    public abstract void rangeChanged(Range range);
    
}
