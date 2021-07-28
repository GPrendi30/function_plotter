package com.mathparser.functions;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.Storage;

public interface FunctionInstruction extends Instruction {

    @Override
    void execute(final Storage storage);

    @Override
    String toString();
}
