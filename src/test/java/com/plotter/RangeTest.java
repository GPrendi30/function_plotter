package com.plotter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class RangeTest {
    
    @Test
    public void testGetMin() {
        Range r = new Range(1.0, 2.0);
        assertEquals(1.0, r.getMin(), 0.001);
    }
    
    @Test
    public void testGetMax() {
        Range r = new Range(1.0, 2.0);
        assertEquals(2.0, r.getMax(), 0.001);
    }
    
    @Test
    public void testSetGetMin() {
        Range r = new Range(1.0, 2.0);
        r.setMin(3.0);
        assertEquals(3.0, r.getMin(), 0.001);
    }
    
    @Test
    public void testSetGetMax() {
        Range r = new Range(1.0, 2.0);
        r.setMax(3.0);
        assertEquals(3.0, r.getMax(), 0.001);
    }
    
    @Test
    public void testAddRangeListenerRangeChangedOnSetMin() {
        Range range = new Range(1.0, 2.0);
        class TestRangeListener implements RangeListener {
            public boolean gotNotified = false;
            public boolean gotNotifiedForFunction = false;
            public void rangeChanged(Range r) {
                gotNotified = true;
                gotNotifiedForFunction = r == range;
            }
        }
        TestRangeListener li = new TestRangeListener();
        range.addRangeListener(li);
        range.setMin(3.0);
        assertTrue(li.gotNotified);
        assertTrue(li.gotNotifiedForFunction);
        
    }
    
    @Test
    public void testAddRangeListenerRangeChangedOnSetMax() {
        Range range = new Range(1.0, 2.0);
        class TestRangeListener implements RangeListener {
            public boolean gotNotified = false;
            public boolean gotNotifiedForFunction = false;
            public void rangeChanged(Range r) {
                gotNotified = true;
                gotNotifiedForFunction = r == range;
            }
        }
        TestRangeListener li = new TestRangeListener();
        range.addRangeListener(li);
        range.setMax(3.0);
        assertTrue(li.gotNotified);
        assertTrue(li.gotNotifiedForFunction);
    }
    
    @Test
    public void testRemoveRangeListenerRangeChanged() {
        Range range = new Range(1.0, 2.0);
        class TestRangeListener implements RangeListener {
            public boolean gotNotified = false;
            public boolean gotNotifiedForFunction = false;
            public void rangeChanged(Range r) {
                gotNotified = true;
                gotNotifiedForFunction = r == range;
            }
        }
        TestRangeListener li = new TestRangeListener();
        range.addRangeListener(li);
        range.removeRangeListener(li);
        range.setMin(3.0);
        range.setMax(3.0);
        assertFalse(li.gotNotified);
        assertFalse(li.gotNotifiedForFunction);
    }
    
}
