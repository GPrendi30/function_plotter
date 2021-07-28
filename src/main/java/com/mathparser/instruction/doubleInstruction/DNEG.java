package com.mathparser.instruction.doubleInstruction;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class DNEG implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.dpush(-stack.dpop());
    }

    @Override
    public String toString() {
        return "DNEG";
    }
}
