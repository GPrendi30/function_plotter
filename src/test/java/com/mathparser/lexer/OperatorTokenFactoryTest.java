package com.mathparser.lexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class OperatorTokenFactoryTest {

    @Test
    public void testPlusFound() {
        OperatorTokenFactory f = new OperatorTokenFactory("+", TokenType.PLUS);
        f.setText("ab+12");
        boolean found = f.find(2);
        assertTrue(found);
        assertEquals(2, f.getTokenStartPosition());
        assertEquals("+", f.getTokenText());
        assertEquals(1, f.getTokenLength());
        assertEquals(2, f.getToken().getStartPosition());
        assertEquals(TokenType.PLUS, f.getToken().getType());
        assertEquals("+", f.getToken().getText());
    }

    @Test
    public void testPlusNotFound() {
        OperatorTokenFactory f = new OperatorTokenFactory("+", TokenType.PLUS);
        f.setText("ab-12");
        boolean found = f.find(2);
        assertFalse(found);
    }

}
