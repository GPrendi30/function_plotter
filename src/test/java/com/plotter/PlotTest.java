package com.plotter;

import static org.junit.Assert.assertSame;
import org.junit.Test;


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
