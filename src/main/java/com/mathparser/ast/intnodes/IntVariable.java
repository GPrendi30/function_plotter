package com.mathparser.ast.intnodes;

import com.mathparser.ast.NodeVariable;
import com.mathparser.ast.Type;
import com.mathparser.instruction.Instruction;
import com.mathparser.instruction.intInstruction.ILOAD;


public class IntVariable extends NodeVariable {


    /**
     * Creates a new variable with a given doubleVarName.
     *
     * @param intVarName a String
     */
    public IntVariable(final String intVarName) {
        super(intVarName);
    }

    @Override
    public Type getType() {
        return Type.INT;
    }

    @Override
    public Instruction instruction() {
        return new ILOAD(varName);
    }
}
