package src.main.java.com.mathparser.ast.intnodes;

import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.lexer.program.Program;

public class IntUnaryNode extends Node {

    protected final Node child;

    /**
     * Create a new src.main.java.com.mathparser.ast.intnodes.IntUnaryNode node.
     * @param child a node
     */
    public IntUnaryNode(final Node child) {
        super();
        this.child = child;
    }

    @Override
    public Type getType() {
        return Type.INT;
    }
    
    @Override
    public boolean isConstant() {
        return child.isConstant();
    }
    
    @Override
    public void compile(final Program p) {
        child.compile(p);
        p.append(instruction());
    }

    /**
     * Returns the jvm instruction of the node.
     * @return the jvm instruction of the node
     */
    public Instruction instruction() {
        return null;
    }

    @Override
    public String toString() {
        return "(-" + child.toString() + ")";
    }

}

