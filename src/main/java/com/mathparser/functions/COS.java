package com.mathparser.functions;

import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class COS extends FunctionNode {

    /**
     * Creates a COS function.
     */
    public COS() {
        super("COS", 1);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                final double a = op.dpop();
                final double cos = Math.cos(a);
                op.dpush(cos);
            }

            @Override
            public String toString() {
                return "cos";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new COS();
    }

}
