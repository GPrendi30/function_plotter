package com.mathparser.ast.generalnodes;

import com.mathparser.ast.Node;
import com.mathparser.ast.Type;
import com.mathparser.ast.doublenodes.DoubleSubtraction;
import com.mathparser.ast.intnodes.IntSubtraction;

public class GeneralSubtraction extends BinaryGeneralNode {

    /**
     * Constructor for src.main.java.com.mathparser.ast.generalnodes.GeneralSubtraction.
     *
     * @param left  a node
     * @param right a node
     */
    public GeneralSubtraction(final Node left, final Node right) {
        super(left, right);
        wrap(getChildrenType() != Type.DOUBLE
                ? new IntSubtraction(leftChild, rightChild)
                : new DoubleSubtraction(leftChild, rightChild));
    }


}
