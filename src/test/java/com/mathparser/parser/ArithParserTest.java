package src.test.java.com.mathparser.parser;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.main.java.com.mathparser.ast.Node;
import src.main.java.com.mathparser.ast.intnodes.IntAddition;
import src.main.java.com.mathparser.ast.intnodes.IntDivision;
import src.main.java.com.mathparser.ast.intnodes.IntLiteral;
import src.main.java.com.mathparser.ast.intnodes.IntMultiplication;
import src.main.java.com.mathparser.ast.intnodes.IntNegation;
import src.main.java.com.mathparser.ast.intnodes.IntSubtraction;
import src.main.java.com.mathparser.ast.intnodes.IntVariable;
import src.main.java.com.mathparser.parser.ArithParser;
import src.main.java.com.mathparser.parser.Parser;


/**
 * This test class will test some aspects of the rules
 * of the Arith language.
 *
 * <code>
 * EXPRESSION   ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
 * TERM         ::= FACTOR { ( "*" | "/" ) FACTOR }
 * FACTOR       ::= Literal |
 *                  Identifier|
 *                  "(" EXPRESSION ")"
 * </code>
 */
public class ArithParserTest {

    @Test
    public void testLiteral() throws Exception {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntLiteral(12);
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testVariable() throws Exception {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "x";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntVariable("x");
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testNegation() throws Exception {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "-11";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntNegation(new Literal(11));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testUnaryPlus() throws Exception {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "+11";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntLiteral(11);
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testAddition() throws Exception {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12+2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntAddition(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testSubtraction() throws Exception {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12-2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntSubtraction(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testMultiplication() throws Exception {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12*2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntMultiplication(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testDivision() throws Exception {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12/2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntDivision(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

}
