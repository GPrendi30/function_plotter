package src.main.java.com.mathparser.ast.generalnodes;

public class GeneralSubtraction extends BinaryGeneralNode {

    /**
     * Constructor for src.main.java.com.mathparser.ast.generalnodes.GeneralSubtraction.
     * @param left a node
     * @param right a node
     */
    public GeneralSubtraction(final Node left, final Node right) {
        super(left, right);
        wrap(getChildrenType() != Type.DOUBLE
                ? new IntSubtraction(leftChild, rightChild)
                : new DoubleSubtraction(leftChild, rightChild));
    }


}
