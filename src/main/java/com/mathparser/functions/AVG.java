package com.mathparser.functions;

import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class AVG extends FunctionNode {
    /**
     * Creates a new src.main.java.com.mathparser.functions.AVG function. Average.
     */
    public AVG() {
        super("AVG", 2);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                op.dpush((op.dpop() + op.dpop()) / 2);
            }

            @Override
            public String toString() {
                return "avg";
            }
        };
    }


    @Override
    public FunctionNode newInstance() {
        return new AVG();
    }
}
