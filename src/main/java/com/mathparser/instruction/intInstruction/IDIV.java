package com.mathparser.instruction.intInstruction;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class IDIV implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.ipush((1 / stack.ipop()) * stack.ipop());
    }

    @Override
    public String toString() {
        return "IDIV";
    }

}
