package src.main.java.com.mathparser.ast;

import src.main.java.com.mathparser.ast.Node;
import src.main.java.com.mathparser.ast.Type;
import src.main.java.com.mathparser.instruction.Instruction;
import src.main.java.com.mathparser.lexer.program.Program;

public class NodeVariable extends Node {

    protected final String varName;
    
    /**
     * Creates a new variable with a given doubleVarName.
     * @param varName a String
     */
    public NodeVariable(final String varName) {
        super();
        this.varName = varName;
    }

    @Override
    public Type getType() {
        return Type.INVALID;
    }

    @Override
    public boolean isConstant() {
        return false;
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
        return this.varName;
    }
}
