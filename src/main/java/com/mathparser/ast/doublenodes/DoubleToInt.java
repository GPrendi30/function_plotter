package com.mathparser.ast.doublenodes;

import com.mathparser.ast.Node;
import com.mathparser.ast.intnodes.IntUnaryNode;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.doubleinstruction.D2I;

public class DoubleToInt extends IntUnaryNode {

    /**
     * Constructs a src.main.java.com.mathparser.ast.doublenodes.DoubleToInt object.
     *
     * @param child a src.main.java.com.mathparser.ast.Node
     */
    public DoubleToInt(final Node child) {
        super(child);
    }

    @Override
    public Instruction instruction() {
        return new D2I();
    }

    @Override
    public String toString() {
        return "int " + child.toString();
    }
}
