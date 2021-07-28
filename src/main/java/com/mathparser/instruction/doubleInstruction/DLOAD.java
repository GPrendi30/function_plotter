package com.mathparser.instruction.doubleInstruction;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;
import com.mathparser.program.VariableTable;

public class DLOAD implements Instruction {

    private final String var;

    /**
     * Creates a new ILOAD Instruction.
     *
     * @param var a String
     */
    public DLOAD(final String var) {
        super();
        this.var = var;
    }

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final VariableTable variableTable = storage.getVariableTable();
        final double xValue = variableTable.getDouble(var);
        stack.dpush(xValue);
    }

    /**
     * Returns a String.
     *
     * @return a String representation of the src.main.java.com.mathparser.ast.Node
     */
    public String toString() {
        return "DLOAD " + var;
    }

}
