package com.plotter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class FunctionTest {
    
    @Test
    public void testSetGetExpression() throws FunctionException {
        Function function = new Function("x/x");
        assertEquals("x/x", function.getExpression());
    }
    
    @Test
    public void testCompute() throws FunctionException {
        Function function = new Function("x*2");
        assertEquals(6.0, function.compute(3), 0.001);
    }
    
    @Test
    public void testAddFunctionListener() throws FunctionException {
        Function function = new Function("x");
        class TestFunctionListener implements FunctionListener {
            public boolean gotNotified = false;
            public boolean gotNotifiedForFunction = false;
            public void functionChanged(Function f) {
                gotNotified = true;
                gotNotifiedForFunction = f == function;
            }
        }
        TestFunctionListener li = new TestFunctionListener();
        function.addFunctionListener(li);
        function.setExpression("x*x");
        assertTrue(li.gotNotified);
        assertTrue(li.gotNotifiedForFunction);
    }
    
    @Test
    public void testRemoveFunctionListener() throws FunctionException {
        Function function = new Function("x");
        class TestFunctionListener implements FunctionListener {
            public boolean gotNotified = false;
            public boolean gotNotifiedForFunction = false;
            public void functionChanged(Function f) {
                gotNotified = true;
                gotNotifiedForFunction = f == function;
            }
        }
        TestFunctionListener li = new TestFunctionListener();
        function.addFunctionListener(li);
        function.removeFunctionListener(li);
        function.setExpression("x*x");
        assertFalse(li.gotNotified);
        assertFalse(li.gotNotifiedForFunction);
    }
    
}
