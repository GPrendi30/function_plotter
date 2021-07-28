package com.mathparser.ast.doublenodes;


import com.mathparser.ast.Node;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.doubleinstruction.DNEG;

/**
 * A src.main.java.com.mathparser.ast.doublenodes.DoubleNegation class (e.g., -5, or -x).
 */
public class DoubleNegation extends DoubleUnaryNode {

    /**
     * Create a new src.main.java.com.mathparser.ast.intnodes.IntNegation node.
     *
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
