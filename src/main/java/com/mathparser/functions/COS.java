package com.mathparser.functions;

import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class COS extends FunctionNode {

    /**
     * Creates a new src.main.java.com.mathparser.functions.COS function. src.main.java.com.mathparser.functions.COS.
     */
    public COS() {
        super("src.main.java.com.mathparser.functions.COS", 1);
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
