package src.main.java.com.mathparser.ast.intnodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.intInstruction.ISUB;

/**
 * An integer src.main.java.com.mathparser.ast.intnodes.IntSubtraction.
 */
public class IntSubtraction extends IntBinaryNode {
    
    /**
     * Create a new src.main.java.com.mathparser.ast.intnodes.IntSubtraction node.
     * @param leftChild the left operand
     * @param rightChild the right operand
     */
    public IntSubtraction(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new ISUB();
    }

    @Override
    public String toString() {
        return super.toString("-");
    }
    
}
