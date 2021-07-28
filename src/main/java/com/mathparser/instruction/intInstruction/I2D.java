package com.mathparser.instruction.intInstruction;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class I2D implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final int val = stack.ipop();
        stack.dpush(val);
    }

    @Override
    public String toString() {
        return "I2D";
    }
}
