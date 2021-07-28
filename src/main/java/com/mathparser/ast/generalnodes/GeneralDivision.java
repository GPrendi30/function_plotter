package src.main.java.com.mathparser.ast.generalnodes;

public class GeneralDivision extends BinaryGeneralNode {

    /**
     * Constructor for src.main.java.com.mathparser.ast.generalnodes.GeneralDivision.
     * @param left a src.main.java.com.mathparser.ast.Node
     * @param right a src.main.java.com.mathparser.ast.Node
     */
    public GeneralDivision(final Node left, final Node right) {
        super(left, right);
        wrap(getChildrenType() != Type.DOUBLE
                ? new IntDivision(leftChild, rightChild)
                : new DoubleDivision(leftChild, rightChild));
    }
}
