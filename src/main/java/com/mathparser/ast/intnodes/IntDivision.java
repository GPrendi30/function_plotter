package com.mathparser.ast.intnodes;

import com.mathparser.ast.Node;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.intInstruction.IDIV;

public class IntDivision extends IntBinaryNode {
    /**
     * Creates a new src.main.java.com.mathparser.ast.intnodes.IntDivision src.main.java.com.mathparser.ast.Node.
     *
     * @param leftChild  a src.main.java.com.mathparser.ast.Node
     * @param rightChild a src.main.java.com.mathparser.ast.Node
     */
    public IntDivision(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new IDIV();
    }

    @Override
    public String toString() {
        return super.toString("/");
    }
}