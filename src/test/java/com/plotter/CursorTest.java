package src.test.java.com.plotter;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.main.java.com.plotter.Cursor;
import src.main.java.com.plotter.CursorListener;


public class CursorTest {
    
    @Test
    public void testGetX() {
        Cursor c = new Cursor(1.0);
        assertEquals(1.0, c.getX(), 0.001);
    }
    
    @Test
    public void testSetGetX() {
        Cursor c = new Cursor(1.0);
        c.setX(2.0);
        assertEquals(2.0, c.getX(), 0.001);
    }
    
    @Test
    public void testAddCursorListener() {
        Cursor cursor = new Cursor(1.0);
        class TestCursorListener implements CursorListener {
            public boolean gotNotified = false;
            public boolean gotNotifiedForFunction = false;
            public void cursorChanged(Cursor c) {
                gotNotified = true;
                gotNotifiedForFunction = c == cursor;
            }
        }
        TestCursorListener li = new TestCursorListener();
        cursor.addCursorListener(li);
        cursor.setX(2.0);
        assertTrue(li.gotNotified);
        assertTrue(li.gotNotifiedForFunction);
    }
    
    @Test
    public void testRemoveCursorListener() {
        Cursor cursor = new Cursor(1.0);
        class TestCursorListener implements CursorListener {
            public boolean gotNotified = false;
            public void cursorChanged(Cursor c) {
                gotNotified = true;
            }
        }
        TestCursorListener li = new TestCursorListener();
        cursor.addCursorListener(li);
        cursor.removeCursorListener(li);
        cursor.setX(2.0);
        assertFalse(li.gotNotified);
    }
}
