package com.mathparser.ast.generalnodes;

import com.mathparser.ast.Node;
import com.mathparser.ast.Type;

public class BinaryGeneralNode extends GeneralNode {

    protected Node leftChild;
    protected Node rightChild;

    /**
     * A Wrapper for binaryNodes.
     *
     * @param left  lhs src.main.java.com.mathparser.ast.Node
     * @param right rhs src.main.java.com.mathparser.ast.Node
     */
    public BinaryGeneralNode(final Node left, final Node right) {
        super();
        this.leftChild = left;
        this.rightChild = right;

        castNodesIfNeeded();
    }

    /**
     * Gets the type of the children Nodes.
     *
     * @return the type of the childer Nodes.
     */
    public Type getChildrenType() {
        return leftChild.getType();
    }

    protected void castNodesIfNeeded() {
        if (leftChild.getType() != Type.INT || rightChild.getType() != Type.INT) {
            if (leftChild.getType() != Type.DOUBLE) {
                leftChild = castToDouble(leftChild);
            } else if (rightChild.getType() != Type.DOUBLE) {
                rightChild = castToDouble(rightChild);
            }
        } else {
            //do nothing.
        }
    }

}
