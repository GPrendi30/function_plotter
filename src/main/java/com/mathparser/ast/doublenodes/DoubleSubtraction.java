package src.main.java.com.mathparser.ast.doublenodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.doubleInstruction.DSUB;

/**
 * An integer src.main.java.com.mathparser.ast.intnodes.IntSubtraction.
 */
public class DoubleSubtraction extends DoubleBinaryNode {
    
    /**
     * Create a new src.main.java.com.mathparser.ast.intnodes.IntSubtraction node.
     * @param leftChild the left operand
     * @param rightChild the right operand
     */
    public DoubleSubtraction(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new DSUB();
    }

    @Override
    public String toString() {
        return super.toString("-");
    }
    
}
