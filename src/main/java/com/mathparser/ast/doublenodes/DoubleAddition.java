package com.mathparser.ast.doublenodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.doubleInstruction.DADD;

/**
 * A Double src.main.java.com.mathparser.ast.generalnodes.GeneralAddition.
 */
public class DoubleAddition extends DoubleBinaryNode {
    
    /**
     * Create a new src.main.java.com.mathparser.ast.doublenodes.DoubleAddition node.
     * @param leftChild the left operand
     * @param rightChild the right operand
     */
    public DoubleAddition(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new DADD();
    }

    @Override
    public String toString() {
        return super.toString("+");
    }
    
}
