package src.test.java.com.plotter;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.main.java.com.plotter.Cursor;
import src.main.java.com.plotter.Function;
import src.main.java.com.plotter.FunctionException;
import src.main.java.com.plotter.Plot;
import src.main.java.com.plotter.Range;


public class PlotTest {
    
    @Test
    public void testGetFunction() throws FunctionException {
        Function f = new Function("1");
        Plot p = new Plot( new Range(1,1), null);
        p.addFunction(f);
        assertSame(f, p.getFunction(0));
    }
    
    @Test
    public void testGetRange() {
        Range r = new Range(0.0, 0.0);
        Plot p = new Plot(r, null);
        assertSame(r, p.getRange());
    }
    
    @Test
    public void testGetCursor() {
        Cursor c = new Cursor(0.0);
        Plot p = new Plot(new Range(0,0), c);
        assertSame(c, p.getCursor());
    }
    
}
