package com.mathparser.ast.generalnodes;

import com.mathparser.ast.Node;
import com.mathparser.ast.Type;
import com.mathparser.ast.doublenodes.DoubleMultiplication;
import com.mathparser.ast.intnodes.IntMultiplication;

public class GeneralMultiplication extends BinaryGeneralNode {

    /**
     * Constructor for src.main.java.com.mathparser.ast.generalnodes.GeneralMultiplication.
     *
     * @param left  a src.main.java.com.mathparser.ast.Node
     * @param right a src.main.java.com.mathparser.ast.Node
     */
    public GeneralMultiplication(final Node left, final Node right) {
        super(left, right);
        wrap(getChildrenType() != Type.DOUBLE
                ? new IntMultiplication(leftChild, rightChild)
                : new DoubleMultiplication(leftChild, rightChild));
    }


}
