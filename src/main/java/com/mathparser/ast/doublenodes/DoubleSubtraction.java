package com.mathparser.ast.doublenodes;

import com.mathparser.ast.Node;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.doubleinstruction.DSUB;

/**
 * An integer src.main.java.com.mathparser.ast.intnodes.IntSubtraction.
 */
public class DoubleSubtraction extends DoubleBinaryNode {

    /**
     * Create a new src.main.java.com.mathparser.ast.intnodes.IntSubtraction node.
     *
     * @param leftChild  the left operand
     * @param rightChild the right operand
     */
    public DoubleSubtraction(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new DSUB();
    }

    @Override
    public String toString() {
        return super.toString("-");
    }

}
