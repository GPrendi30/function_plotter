package src.main.java.com.plotter;

import java.util.ArrayList;


/**
 * A src.main.java.com.plotter.Cursor represents a point along the x-axis.
 * Its position is mutable.
 */
public class Cursor {

    private final ArrayList<CursorListener> listeners;
    private double x;
    private double y;
    
    /**
     * Create a new src.main.java.com.plotter.Cursor at the given x-coordinate.
     * @param initialX The initial position of the cursor.
     */
    public Cursor(final double initialX) {
        listeners = new ArrayList<CursorListener>();
        this.x = initialX;
    }

    /**
     * Return the current position along the x-coordinate of this src.main.java.com.plotter.Cursor.
     * @return the current position
     */
    public final double getX() {
        return x;
    }

    /**
     * Get the y coordinate of the cursor.
     * @return get the y coordinate
     */
    public final double getY() {
        return y;
    }

    /**
     * Set the Y coordinate.
     * @param y the y coordinate.
     */
    public final void setY(final double y) {
        this.y = y;
    }

    /**
     * Set the position of the src.main.java.com.plotter.Cursor to the given x-coordinate.
     * @param x The new x-coordinate of this src.main.java.com.plotter.Cursor.
     */
    public final void setX(final double x) {
        this.x = x;
        fireCursorChanged();
    }

    /**
     * Register the given src.main.java.com.plotter.CursorListener,
     * so it will be notified whenever this src.main.java.com.plotter.Cursor changes.
     * @param li The src.main.java.com.plotter.CursorListener to register
     */
    public final void addCursorListener(final CursorListener li) {
        listeners.add(li);
    }
    
    /**
     * Unregister the given src.main.java.com.plotter.CursorListener,
     * so it will not be notified anymore whenever this src.main.java.com.plotter.Cursor changes.
     * @param li The src.main.java.com.plotter.CursorListener to unregister
     */
    public final void removeCursorListener(final CursorListener li) {
        listeners.remove(li);
    }
    
    /**
     * Notify all registered CursorListeners that this src.main.java.com.plotter.Cursor has changed.
     */
    private void fireCursorChanged() {
        for (final CursorListener li : listeners) {
            li.cursorChanged(this);
        }
    }
    
}
