package com.mathparser.ast.doublenodes;


import com.mathparser.ast.Node;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.doubleInstruction.DMUL;

public class DoubleMultiplication extends DoubleBinaryNode {

    /**
     * Creates a new src.main.java.com.mathparser.ast.doublenodes.DoubleMultiplication src.main.java.com.mathparser.ast.Node.
     *
     * @param leftChild  a src.main.java.com.mathparser.ast.Node
     * @param rightChild a src.main.java.com.mathparser.ast.Node
     */
    public DoubleMultiplication(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new DMUL();
    }

    @Override
    public String toString() {
        return super.toString("*");
    }
}

