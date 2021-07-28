package src.main.java.com.mathparser.ast.doublenodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.doubleInstruction.DLOAD;

public class DoubleVariable extends NodeVariable {

    /**
     * Creates a new variable with a given doubleVarName.
     * @param doubleVarName a String
     */
    public DoubleVariable(final String doubleVarName) {
        super(doubleVarName);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }
    
    @Override
    public Instruction instruction() {
        return new DLOAD(varName);
    }   
}
