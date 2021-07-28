package com.mathparser.ast.doublenodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.doubleInstruction.DDIV;

public class DoubleDivision extends DoubleBinaryNode {
    /**
     * Creates a new src.main.java.com.mathparser.ast.intnodes.IntDivision src.main.java.com.mathparser.ast.Node.
     * @param leftChild a src.main.java.com.mathparser.ast.Node
     * @param rightChild a src.main.java.com.mathparser.ast.Node
     */
    public DoubleDivision(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new DDIV();
    }

    @Override
    public String toString() {
        return super.toString("/");
    }
}