package com.mathparser.program;

/**
 * The "memory" to use during program execution.
 * In our little language, the memory consists
 * of a table of variables and
 * an operand stack to hold intermediate values.
 */
public class Storage {

    private final OperandStack stack;
    private final VariableTable variables;

    /**
     * Create a src.main.java.com.mathparser.program.Storage.
     *
     * @param stack     The src.main.java.com.mathparser.program.OperandStack
     * @param variables The src.main.java.com.mathparser.program.VariableTable
     */
    public Storage(final OperandStack stack, final VariableTable variables) {
        this.stack = stack;
        this.variables = variables;
    }

    /**
     * Get the src.main.java.com.mathparser.program.OperandStack.
     *
     * @return The src.main.java.com.mathparser.program.OperandStack
     */
    public OperandStack getOperandStack() {
        return stack;
    }

    /**
     * Get the src.main.java.com.mathparser.program.VariableTable.
     *
     * @return The src.main.java.com.mathparser.program.VariableTable
     */
    public VariableTable getVariableTable() {
        return variables;
    }

}
