package com.mathparser.ast.doublenodes;

import src.main.java.com.mathparser.ast.intnodes.IntBinaryNode;

public class DoubleBinaryNode extends IntBinaryNode {
    /**
     * Constructor.
     * @param leftChild a src.main.java.com.mathparser.ast.Node
     * @param rightChild a src.main.java.com.mathparser.ast.Node
     */
    public DoubleBinaryNode(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }
}
