package com.mathparser.program;

import com.mathparser.ast.Node;
import com.mathparser.ast.doublenodes.DoubleAddition;
import com.mathparser.ast.doublenodes.DoubleDivision;
import com.mathparser.ast.doublenodes.DoubleLiteral;
import com.mathparser.ast.doublenodes.DoubleMultiplication;
import com.mathparser.ast.doublenodes.DoubleNegation;
import com.mathparser.ast.doublenodes.DoubleSubtraction;
import com.mathparser.ast.doublenodes.DoubleToInt;
import com.mathparser.ast.doublenodes.DoubleVariable;
import com.mathparser.ast.intnodes.IntAddition;
import com.mathparser.ast.intnodes.IntDivision;
import com.mathparser.ast.intnodes.IntLiteral;
import com.mathparser.ast.intnodes.IntMultiplication;
import com.mathparser.ast.intnodes.IntNegation;
import com.mathparser.ast.intnodes.IntSubtraction;
import com.mathparser.ast.intnodes.IntToDouble;
import com.mathparser.ast.intnodes.IntVariable;
import com.mathparser.instruction.doubleinstruction.BDPUSH;
import com.mathparser.instruction.doubleinstruction.D2I;
import com.mathparser.instruction.doubleinstruction.DADD;
import com.mathparser.instruction.doubleinstruction.DDIV;
import com.mathparser.instruction.doubleinstruction.DLOAD;
import com.mathparser.instruction.doubleinstruction.DMUL;
import com.mathparser.instruction.doubleinstruction.DNEG;
import com.mathparser.instruction.doubleinstruction.DSUB;
import com.mathparser.instruction.intinstruction.BIPUSH;
import com.mathparser.instruction.intinstruction.I2D;
import com.mathparser.instruction.intinstruction.IADD;
import com.mathparser.instruction.intinstruction.IDIV;
import com.mathparser.instruction.intinstruction.ILOAD;
import com.mathparser.instruction.intinstruction.IMUL;
import com.mathparser.instruction.intinstruction.INEG;
import com.mathparser.instruction.intinstruction.ISUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 * Test compile() of com.mathparser.ast.Node subclasses
 * (and toString() of com.mathparser.instruction.Instruction subclasses).
 * This tests that the compile() methods generate the correct
 * sequence of Instructions.
 */
public class CompilerTest {

    @Test
    public void testIntLiteral() {
        Compiler c = new Compiler();
        Node n = new IntLiteral(5);
        Program p = c.compile(n);
        assertEquals(1, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
    }

    @Test
    public void testIntNegation() {
        Compiler c = new Compiler();
        Node n = new IntNegation(new IntLiteral(5));
        Program p = c.compile(n);
        assertEquals(2, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof INEG);
    }
    
    @Test
    public void testIntAddition() {
        Compiler c = new Compiler();
        Node n = new IntAddition(new IntLiteral(5), new IntLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BIPUSH);
        assertEquals(new BIPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof IADD);
    }
    
    @Test
    public void testIntSubtraction() {
        Compiler c = new Compiler();
        Node n = new IntSubtraction(new IntLiteral(5), new IntLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BIPUSH);
        assertEquals(new BIPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof ISUB);
    }

    @Test
    public void testIntMultiplication() {
        Compiler c = new Compiler();
        Node n = new IntMultiplication(new IntLiteral(5), new IntLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BIPUSH);
        assertEquals(new BIPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof IMUL);
    }
    
    @Test
    public void testIntDivision() {
        Compiler c = new Compiler();
        Node n = new IntDivision(new IntLiteral(5), new IntLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BIPUSH);
        assertEquals(new BIPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof IDIV);
    }

    @Test
    public void testVariable() {
        Compiler c = new Compiler();
        Node n = new IntVariable("x");
        Program p = c.compile(n);
        assertEquals(1, p.getLength());
        assertTrue(p.get(0) instanceof ILOAD);
        assertEquals(new ILOAD("x").toString(), p.get(0).toString());
    }
    
    @Test
    public void testDoubleLiteral() {
        Compiler c = new Compiler();
        Node n = new DoubleLiteral(5);
        Program p = c.compile(n);
        assertEquals(1, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
    }

    @Test
    public void testDoubleNegation() {
        Compiler c = new Compiler();
        Node n = new DoubleNegation(new DoubleLiteral(5));
        Program p = c.compile(n);
        assertEquals(2, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof DNEG);
    }

    @Test
    public void testDoubleAddition() {
        Compiler c = new Compiler();
        Node n = new DoubleAddition(new DoubleLiteral(5), new DoubleLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BDPUSH);
        assertEquals(new BDPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof DADD);
    }

    @Test
    public void testDoubleSubtraction() {
        Compiler c = new Compiler();
        Node n = new DoubleSubtraction(new DoubleLiteral(5), new DoubleLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BDPUSH);
        assertEquals(new BDPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof DSUB);
    }

    @Test
    public void testDoubleMultiplication() {
        Compiler c = new Compiler();
        Node n = new DoubleMultiplication(new DoubleLiteral(5), new DoubleLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BDPUSH);
        assertEquals(new BDPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof DMUL);
    }

    @Test
    public void testDoubleDivision() {
        Compiler c = new Compiler();
        Node n = new DoubleDivision(new DoubleLiteral(5), new DoubleLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BDPUSH);
        assertEquals(new BDPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof DDIV);
    }

    @Test
    public void testDoubleVariable() {
        Compiler c = new Compiler();
        Node n = new DoubleVariable("x");
        Program p = c.compile(n);
        assertEquals(1, p.getLength());
        assertTrue(p.get(0) instanceof DLOAD);
        assertEquals(new DLOAD("x").toString(), p.get(0).toString());
    }

    @Test
    public void testDoubleToInt() {
        Compiler c = new Compiler();
        Node n = new DoubleToInt(new DoubleLiteral(5.3));
        Program p = c.compile(n);
        assertEquals(2, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertTrue(p.get(1) instanceof D2I);
        assertEquals(new D2I().toString(), p.get(1).toString());
    }

    @Test
    public void testIntToDouble() {
        Compiler c = new Compiler();
        Node n = new IntToDouble(new IntLiteral(5));
        Program p = c.compile(n);
        assertEquals(2, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertTrue(p.get(1) instanceof I2D);
        assertEquals(new I2D().toString(), p.get(1).toString());
    }

}
