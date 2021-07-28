package com.mathparser.ast.doublenodes;

import com.mathparser.ast.NodeVariable;
import com.mathparser.ast.Type;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.doubleinstruction.DLOAD;


public class DoubleVariable extends NodeVariable {

    /**
     * Creates a new variable with a given doubleVarName.
     *
     * @param doubleVarName a String
     */
    public DoubleVariable(final String doubleVarName) {
        super(doubleVarName);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }

    @Override
    public Instruction instruction() {
        return new DLOAD(varName);
    }
}
