package src.main.java.com.mathparser.ast.generalnodes;

public class GeneralNegation extends GeneralNode {

    /**
     * Constructor src.main.java.com.mathparser.ast.generalnodes.GeneralNegation.
     * @param child a node.
     */
    public GeneralNegation(final Node child) {
        super();
        super.wrap(defineType(child));
    }

    private Node defineType(final Node child) {
        return child.getType() != Type.INT
                ?  new DoubleNegation(child)
                :  new IntNegation(child);
    }
}
