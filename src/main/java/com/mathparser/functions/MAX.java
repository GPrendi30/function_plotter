package com.mathparser.functions;

import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class MAX extends FunctionNode {

    /**
     * Creates a src.main.java.com.mathparser.functions.MAX function. Maximum.
     */
    public MAX() {
        super("MAX", 2);
    }


    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                final double greatest = Math.max(op.dpop(), op.dpop());
                op.dpush(greatest);
            }

            @Override
            public String toString() {
                return "min";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new MAX();
    }
}
