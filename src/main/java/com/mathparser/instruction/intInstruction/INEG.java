package com.mathparser.instruction.intInstruction;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

/**
 * INEG negates the top value from the OperandStack
 * and ipushes the result back to the OperandStack.
 */
public class INEG implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.ipush(-stack.ipop());
    }

    @Override
    public String toString() {
        return "INEG";
    }

}
