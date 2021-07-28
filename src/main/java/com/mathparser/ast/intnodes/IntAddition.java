package src.main.java.com.mathparser.ast.intnodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.intInstruction.IADD;

/**
 * An integer src.main.java.com.mathparser.ast.intnodes.IntAddition.
 */
public class IntAddition extends IntBinaryNode {
    
    /**
     * Create a new src.main.java.com.mathparser.ast.intnodes.IntAddition node.
     * @param leftChild the left operand
     * @param rightChild the right operand
     */
    public IntAddition(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new IADD();
    }

    @Override
    public String toString() {
        return super.toString("+");
    }
    
}
