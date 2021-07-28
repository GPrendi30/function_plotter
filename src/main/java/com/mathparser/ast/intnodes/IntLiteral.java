package src.main.java.com.mathparser.ast.intnodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.intInstruction.BIPUSH;

/**
 * A Literal is an AST node that 
 * corresponds to a literal integer intValue
 * (a number in the source code).
 */
public class IntLiteral extends NodeLiteral {
    
    /**
     * Creates a new variable with a given doubleVarName.
     * @param intValue an Integer
     */
    public IntLiteral(final int intValue) {
        super(intValue);
    }

    @Override
    public Type getType() {
        return Type.INT;
    }
    
    @Override
    public Instruction instruction() {
        return new BIPUSH(value.intValue());
    }   
}
