package src.main.java.com.mathparser.ast;

import src.main.java.com.mathparser.ast.Node;
import src.main.java.com.mathparser.ast.Type;
import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.lexer.program.Program;

public class NodeLiteral extends Node {
    
    protected final Number value;
    
    /**
     * Create a new src.main.java.com.mathparser.ast.NodeLiteral node.
     * @param value the integer doubleValue this node evaluates to
     */
    public NodeLiteral(final Number value) {
        super();
        this.value = value;
    }

    @Override
    public Type getType() {
        return Type.INVALID;
    }

    @Override
    public boolean isConstant() {
        return true;
    }
    
    @Override
    public void compile(final Program p) {
        p.append(instruction());
    }

    /**
     * Returns the JVM instruction of the src.main.java.com.mathparser.ast.Node.
     * @return the JVM instruction of the src.main.java.com.mathparser.ast.Node.
     */
    public Instruction instruction() {
        return null;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
    
}