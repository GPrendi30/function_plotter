package src.main.java.com.plotter;

public interface PlotListener {

    /**
     * Fires plot changed.
     * @param plot a src.main.java.com.plotter.Plot.
     */
    public abstract void firePlotChanged(final Plot plot);

}
