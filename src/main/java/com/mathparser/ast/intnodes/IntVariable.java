package src.main.java.com.mathparser.ast.intnodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.intInstruction.ILOAD;

public class IntVariable extends NodeVariable {
    
    
    /**
     * Creates a new variable with a given doubleVarName.
     * @param intVarName a String
     */
    public IntVariable(final String intVarName) {
        super(intVarName);
    }

    @Override
    public Type getType() {
        return Type.INT;
    }
    
    @Override
    public Instruction instruction() {
        return new ILOAD(varName);
    }   
}
