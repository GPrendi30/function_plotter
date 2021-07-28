package com.mathparser.program;

import com.mathparser.instruction.Instruction;
import java.util.ArrayList;

/**
 * A compiled program,
 * consisting of a list of IJVM-like Instructions.
 */
public class Program {

    private final ArrayList<Instruction> code;


    /**
     * Create a new empty program.
     */
    public Program() {
        this.code = new ArrayList<Instruction>();
    }

    /**
     * Append the given src.main.java.com.mathparser.instruction.Instruction to this program.
     *
     * @param instruction The src.main.java.com.mathparser.instruction.Instruction to append
     */
    public void append(final Instruction instruction) {
        code.add(instruction);
    }

    /**
     * Get the number of Instructions of this program.
     *
     * @return the length, in number of Instructions
     */
    public int getLength() {
        return code.size();
    }

    /**
     * Get the src.main.java.com.mathparser.instruction.Instruction at the given index in the program.
     *
     * @param index the index
     * @return the src.main.java.com.mathparser.instruction.Instruction at the given index
     */
    public Instruction get(final int index) {
        return code.get(index);
    }


    /**
     * Execute this program, returning the result.
     * The result is the top element of the operand stack,
     * after executing all Instructions.
     *
     * @return The result of the execution.
     */
    public int iExecute() {
        final VariableTable variables = new VariableTable();
        return iExecute(variables);
    }

    /**
     * Execute this program, returning the result.
     * The result is the top element of the operand stack,
     * after executing all Instructions.
     *
     * @param variables The variables with their values
     *                  (accessed by src.main.java.com.mathparser.instruction.intInstruction.ILOAD Instructions)
     * @return The result of the execution.
     */
    public int iExecute(final VariableTable variables) {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, variables);
        for (final Instruction Instruction : code) {
            Instruction.execute(storage);
        }
        return stack.ipop();
    }

    /**
     * Execute this program, returning the result.
     * The result is the top element of the operand stack,
     * after executing all Instructions.
     *
     * @return The result of the execution.
     */
    public double dExecute() {
        final VariableTable variables = new VariableTable();
        return dExecute(variables);
    }

    /**
     * Execute this program, returning the result.
     * The result is the top element of the operand stack,
     * after executing all Instructions.
     *
     * @param variables The variables with their values
     *                  (accessed by src.main.java.com.mathparser.instruction.intInstruction.ILOAD Instructions)
     * @return The result of the execution.
     */
    public double dExecute(final VariableTable variables) {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, variables);
        for (final Instruction Instruction : code) {
            Instruction.execute(storage);
        }
        return stack.dpop();
    }


    /**
     * Disassemble this program into a String,
     * with one bytecode src.main.java.com.mathparser.instruction.Instruction per line.
     *
     * @return A String-representation of this program.
     */
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final Instruction Instruction : code) {
            builder.append("  ");
            builder.append(Instruction.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

}
