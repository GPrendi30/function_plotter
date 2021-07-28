package src.main.java.com.mathparser.instruction;

import src.main.java.com.mathparser.lexer.program.Storage;

/**
 * An IJVM-like src.main.java.com.mathparser.instruction.Instruction.
 */
public interface Instruction {
    
    /**
     * Execute this src.main.java.com.mathparser.instruction.Instruction.
     * @param storage The "memory" to use during the execution
     */
    public abstract void execute(final Storage storage);
    
    /**
     * Get a String with the disassembled src.main.java.com.mathparser.instruction.Instruction.
     * @return A String-representation of this src.main.java.com.mathparser.instruction.Instruction.
     */
    public abstract String toString();
    
}
