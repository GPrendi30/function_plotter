package com.mathparser.ast.doublenodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.doubleInstruction.DNEG;

/**
 * A src.main.java.com.mathparser.ast.doublenodes.DoubleNegation class (e.g., -5, or -x).
 */
public class DoubleNegation extends DoubleUnaryNode {
        
    /**
     * Create a new src.main.java.com.mathparser.ast.intnodes.IntNegation node.
     * @param child the operand we will negate
     */
    public DoubleNegation(final Node child) {
        super(child);
    }
    
    @Override
    public Instruction instruction() {
        return new DNEG();
    }
    
}
