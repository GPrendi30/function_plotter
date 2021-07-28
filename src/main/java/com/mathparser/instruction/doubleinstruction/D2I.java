package com.mathparser.instruction.doubleinstruction;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class D2I implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final double val = stack.ipop();
        stack.ipush((int) val);
    }

    @Override
    public String toString() {
        return "D2I";
    }

}
