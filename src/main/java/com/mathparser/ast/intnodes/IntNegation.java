package com.mathparser.ast.intnodes;

import com.mathparser.ast.Node;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.intInstruction.INEG;

/**
 * An integer src.main.java.com.mathparser.ast.intnodes.IntNegation (e.g., -5, or -x).
 */
public class IntNegation extends IntUnaryNode {

    /**
     * Create a new src.main.java.com.mathparser.ast.intnodes.IntNegation node.
     *
     * @param child the operand we will negate
     */
    public IntNegation(final Node child) {
        super(child);
    }

    @Override
    public Instruction instruction() {
        return new INEG();
    }

}
