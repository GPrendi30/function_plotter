package com.mathparser.ast.intnodes;

import com.mathparser.ast.Node;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.intinstruction.IDIV;

public class IntDivision extends IntBinaryNode {
    /**
     * Creates a new IntDivision Node.
     *
     * @param leftChild  a Node
     * @param rightChild a Node
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