package src.main.java.com.mathparser.ast.intnodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.instruction.intInstruction.IMUL;

public class IntMultiplication extends IntBinaryNode {

    /**
     * Creates a new src.main.java.com.mathparser.ast.intnodes.IntMultiplication src.main.java.com.mathparser.ast.Node.
     * @param leftChild a src.main.java.com.mathparser.ast.Node
     * @param rightChild a src.main.java.com.mathparser.ast.Node
     */
    public IntMultiplication(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new IMUL();
    }

    @Override
    public String toString() {
        return super.toString("*");
    }
}

