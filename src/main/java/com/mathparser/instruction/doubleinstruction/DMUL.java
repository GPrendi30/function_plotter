package com.mathparser.instruction.doubleinstruction;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class DMUL implements Instruction {


    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.dpush(stack.dpop() * stack.dpop());
    }

    @Override
    public String toString() {
        return "DMUL";
    }

}
