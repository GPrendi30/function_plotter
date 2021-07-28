package src.test.java.com.mathparser.instruction;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.doubleInstruction.BDPUSH;
import src.main.java.com.mathparser.instruction.doubleInstruction.D2I;
import src.main.java.com.mathparser.instruction.doubleInstruction.DADD;
import src.main.java.com.mathparser.instruction.doubleInstruction.DDIV;
import src.main.java.com.mathparser.instruction.doubleInstruction.DLOAD;
import src.main.java.com.mathparser.instruction.doubleInstruction.DMUL;
import src.main.java.com.mathparser.instruction.doubleInstruction.DNEG;
import src.main.java.com.mathparser.instruction.doubleInstruction.DSUB;
import src.main.java.com.mathparser.instruction.intInstruction.BIPUSH;
import src.main.java.com.mathparser.instruction.intInstruction.I2D;
import src.main.java.com.mathparser.instruction.intInstruction.IADD;
import src.main.java.com.mathparser.instruction.intInstruction.IDIV;
import src.main.java.com.mathparser.instruction.intInstruction.ILOAD;
import src.main.java.com.mathparser.instruction.intInstruction.IMUL;
import src.main.java.com.mathparser.instruction.intInstruction.INEG;
import src.main.java.com.mathparser.instruction.intInstruction.ISUB;
import src.main.java.com.mathparser.lexer.program.OperandStack;
import src.main.java.com.mathparser.lexer.program.Storage;
import src.main.java.com.mathparser.lexer.program.VariableTable;


/**
 * Tests toString() and execute() of src.main.java.com.mathparser.instruction.Instruction subclasses.
 */
public class InstructionTest {
    


    @Test
    public void testToStringBIPUSH() {
        Instruction i = new BIPUSH(1);
        assertEquals("src.main.java.com.mathparser.instruction.intInstruction.BIPUSH 1", i.toString());
    }
    
    @Test
    public void testExecuteBIPUSH() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        Instruction i = new BIPUSH(1);
        i.execute(s);
        assertEquals(1, os.ipop());
    }
    
    
    @Test
    public void testToStringINEG() {
        Instruction i = new INEG();
        assertEquals("src.main.java.com.mathparser.instruction.intInstruction.INEG", i.toString());
    }
    
    @Test
    public void testExecuteINEG() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.ipush(1);
        Instruction i = new INEG();
        i.execute(s);
        assertEquals(-1, os.ipop());
    }

    
    @Test
    public void testToStringIADD() {
        Instruction i = new IADD();
        assertEquals("src.main.java.com.mathparser.instruction.intInstruction.IADD", i.toString());
    }
    
    @Test
    public void testExecuteIADD() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.ipush(1);
        os.ipush(2);
        Instruction i = new IADD();
        i.execute(s);
        assertEquals(3, os.ipop());
    }

    
    @Test
    public void testToStringISUB() {
        Instruction i = new ISUB();
        assertEquals("src.main.java.com.mathparser.instruction.intInstruction.ISUB", i.toString());
    }
    
    @Test
    public void testExecuteISUB() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.ipush(3);
        os.ipush(2);
        Instruction i = new ISUB();
        i.execute(s);
        assertEquals(1, os.ipop());
    }

    @Test
    public void testToStringIMUL() {
        Instruction i = new IMUL();
        assertEquals("src.main.java.com.mathparser.instruction.intInstruction.IMUL", i.toString());
    }
    
    @Test
    public void testExecuteIMUL() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.ipush(1);
        os.ipush(2);
        Instruction i = new IMUL();
        i.execute(s);
        assertEquals(2, os.ipop());
    }

    @Test
    public void testToStringIDIV() {
        Instruction i = new IDIV();
        assertEquals("src.main.java.com.mathparser.instruction.intInstruction.IDIV", i.toString());
    }
    
    @Test
    public void testExecuteIDIV() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.ipush(3);
        os.ipush(1);
        Instruction i = new IDIV();
        i.execute(s);
        assertEquals(3, os.ipop());
    }

    @Test
    public void testToStringILOAD() {
        Instruction i = new ILOAD("x");
        assertEquals("src.main.java.com.mathparser.instruction.intInstruction.ILOAD x", i.toString());
    }
    
    @Test
    public void testExecuteILOAD() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        
        // init src.main.java.com.mathparser.instruction.Instruction: src.main.java.com.mathparser.instruction.intInstruction.ILOAD x
        Instruction i = new ILOAD("x");
        vt.iset("x", 10); // set x to 10

        os.ipush(vt.getInt("x")); // push the value of x in the stack
        i.execute(s);
        assertEquals(10, os.ipop());
    }

    @Test
    public void testToStringBDPUSH() {
        Instruction i = new BDPUSH(1);
        assertEquals("src.main.java.com.mathparser.instruction.doubleInstruction.BDPUSH 1.0", i.toString());
    }
    
    @Test
    public void testExecuteBDPUSH() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        Instruction i = new BDPUSH(1.5);
        i.execute(s);
        assertEquals(1.5, os.dpop(), 0.1);
    }
    
    
    @Test
    public void testToStringDNEG() {
        Instruction i = new DNEG();
        assertEquals("src.main.java.com.mathparser.instruction.doubleInstruction.DNEG", i.toString());
    }
    
    @Test
    public void testExecuteDNEG() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.dpush(1);
        Instruction i = new DNEG();
        i.execute(s);
        assertEquals(-1.0, os.dpop(), 0.1);
    }

    
    @Test
    public void testToStringDADD() {
        Instruction i = new DADD();
        assertEquals("src.main.java.com.mathparser.instruction.doubleInstruction.DADD", i.toString());
    }
    
    @Test
    public void testExecuteDADD() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.dpush(1);
        os.dpush(2);
        Instruction i = new DADD();
        i.execute(s);
        assertEquals(3.0, os.dpop(), 0.1);
    }

    
    @Test
    public void testToStringDSUB() {
        Instruction i = new DSUB();
        assertEquals("src.main.java.com.mathparser.instruction.doubleInstruction.DSUB", i.toString());
    }
    
    @Test
    public void testExecuteDSUB() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.dpush(3);
        os.dpush(2);
        Instruction i = new DSUB();
        i.execute(s);
        assertEquals(1.0, os.dpop(), 0.1);
    }

    @Test
    public void testToStringDMUL() {
        Instruction i = new DMUL();
        assertEquals("src.main.java.com.mathparser.instruction.doubleInstruction.DMUL", i.toString());
    }
    
    @Test
    public void testExecuteDMUL() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.dpush(1);
        os.dpush(2);
        Instruction i = new DMUL();
        i.execute(s);
        assertEquals(2.0, os.dpop(), 0.1);
    }

    @Test
    public void testToStringDDIV() {
        Instruction i = new DDIV();
        assertEquals("src.main.java.com.mathparser.instruction.doubleInstruction.DDIV", i.toString());
    }
    
    @Test
    public void testExecuteDDIV() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.dpush(4);
        os.dpush(2);
        Instruction i = new DDIV();
        i.execute(s);
        assertEquals(2, os.dpop(), 0.1);
    }

    @Test
    public void testToStringDLOAD() {
        Instruction i = new DLOAD("x");
        assertEquals("src.main.java.com.mathparser.instruction.doubleInstruction.DLOAD x", i.toString());
    }
    
    @Test
    public void testExecuteDLOAD() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        
        // init src.main.java.com.mathparser.instruction.Instruction: src.main.java.com.mathparser.instruction.doubleInstruction.DLOAD x
        Instruction i = new DLOAD("x");
        vt.dset("x", 10.0); // set x to 10

        os.dpush(vt.getDouble("x")); // push the value of x in the stack
        i.execute(s);
        assertEquals(10.0, os.dpop(), 0.1);
    }

    @Test
    public void testToStringD2I() {
        Instruction i = new D2I();
        assertEquals("src.main.java.com.mathparser.instruction.doubleInstruction.D2I", i.toString());
    }

    @Test
    public void testExecuteD2I() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        
        os.dpush(1.5);
        Instruction i = new D2I();
        i.execute(s);
        assertEquals(1, os.ipop());
    }

    @Test
    public void testToStringI2D() {
        Instruction i = new I2D();
        assertEquals("src.main.java.com.mathparser.instruction.intInstruction.I2D", i.toString());
    }

    @Test
    public void testExecuteI2D() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        
        os.ipush(1);
        Instruction i = new I2D();
        i.execute(s);
        assertEquals(1.0, os.dpop(), 0.01);
    }

}
