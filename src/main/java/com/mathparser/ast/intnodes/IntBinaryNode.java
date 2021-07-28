package com.mathparser.ast.intnodes;


import com.mathparser.ast.Node;
import com.mathparser.ast.Type;
import com.mathparser.instruction.Instruction;
import com.mathparser.program.Program;

public class IntBinaryNode extends Node {

    private final Node leftChild;
    private final Node rightChild;

    /**
     * Constructor.
     *
     * @param leftChild  a src.main.java.com.mathparser.ast.Node
     * @param rightChild a src.main.java.com.mathparser.ast.Node
     */
    public IntBinaryNode(final Node leftChild, final Node rightChild) {
        super();
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }

    @Override
    public Type getType() {
        return Type.INT;
    }

    @Override
    public boolean isConstant() {
        return leftChild.isConstant() && rightChild.isConstant();
    }

    @Override
    public void compile(final Program p) {
        leftChild.compile(p);
        rightChild.compile(p);
        p.append(instruction());
    }

    /**
     * Returns the String representation of the node.
     *
     * @param op -> String
     * @return the String representation of the node
     */
    public String toString(final String op) {
        return "(" + leftChild.toString() + op + rightChild.toString() + ")";
    }

    /**
     * Returns the src.main.java.com.mathparser.instruction.Instruction of the node.
     *
     * @return the jvm src.main.java.com.mathparser.instruction.Instruction
     */
    public Instruction instruction() {
        return null;
    }

}
