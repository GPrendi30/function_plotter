package com.mathparser.ast.doublenodes;

import com.mathparser.ast.Node;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.doubleinstruction.DDIV;


public class DoubleDivision extends DoubleBinaryNode {
    /**
     * Creates a new IntDivision Node.
     *
     * @param leftChild  a Node
     * @param rightChild a Node
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