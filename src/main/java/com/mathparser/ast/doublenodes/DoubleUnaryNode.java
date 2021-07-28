package com.mathparser.ast.doublenodes;


import com.mathparser.ast.Node;
import com.mathparser.ast.Type;
import com.mathparser.ast.intnodes.IntUnaryNode;

public class DoubleUnaryNode extends IntUnaryNode {
    /**
     * Create a new src.main.java.com.mathparser.ast.doublenodes.DoubleUnaryNode node.
     *
     * @param child the operand we will negate
     */
    public DoubleUnaryNode(final Node child) {
        super(child);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }
}

