package src.main.java.com.mathparser.ast.generalnodes;

public class GeneralAddition extends BinaryGeneralNode {

    /**
     * Constructor for src.main.java.com.mathparser.ast.generalnodes.GeneralAddition.
     * @param left a src.main.java.com.mathparser.ast.Node
     * @param right a src.main.java.com.mathparser.ast.Node
     */
    public GeneralAddition(final Node left, final Node right) {
        super(left, right);
        wrap(getChildrenType() != Type.DOUBLE
                ? new IntAddition(leftChild, rightChild)
                : new DoubleAddition(leftChild, rightChild));
    }
}
