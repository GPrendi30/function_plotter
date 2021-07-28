package com.mathparser.ast.intnodes;

import com.mathparser.ast.Node;
import com.mathparser.ast.doublenodes.DoubleUnaryNode;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.intInstruction.I2D;

public class IntToDouble extends DoubleUnaryNode {

    /**
     * Creates an src.main.java.com.mathparser.ast.intnodes.IntToDouble object.
     *
     * @param child a src.main.java.com.mathparser.ast.Node
     */
    public IntToDouble(final Node child) {
        super(child);
    }

    @Override
    public Instruction instruction() {
        return new I2D();
    }

    @Override
    public String toString() {
        return "double " + child.toString();
    }

}
