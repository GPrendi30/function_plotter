package com.mathparser.ast.doublenodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.doubleInstruction.BDPUSH;

/**
 * A Literal is an AST node that 
 * corresponds to a literal integer doubleValue
 * (a number in the source code).
 */
public class DoubleLiteral extends NodeLiteral {
    
    /**
     * Creates a new literal with a given doubleValue.
     * @param doubleValue a double vaulue for src.main.java.com.mathparser.ast.doublenodes.DoubleLiteral
     */
    public DoubleLiteral(final double doubleValue) {
        super(doubleValue);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }
    
    @Override
    public Instruction instruction() {
        return new BDPUSH(value.doubleValue());
    }   
    
}
