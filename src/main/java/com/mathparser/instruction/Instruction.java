package com.mathparser.instruction;

import com.mathparser.program.Storage;

/**
 * An IJVM-like Instruction.
 */
public interface Instruction {

    /**
     * Execute this src.main.java.com.mathparser.instruction.Instruction.
     *
     * @param storage The "memory" to use during the execution
     */
    void execute(final Storage storage);

    /**
     * Get a String with the disassembled Instruction.
     *
     * @return A String-representation of this Instruction.
     */
    String toString();

}
