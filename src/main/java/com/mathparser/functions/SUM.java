package com.mathparser.functions;

import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class SUM extends FunctionNode {

    /**
     * Creates a new src.main.java.com.mathparser.functions.SUM. summation.
     */
    public SUM() {
        super("src.main.java.com.mathparser.functions.SUM", 2);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                op.dpush(op.dpop() + op.dpop());
            }

            @Override
            public String toString() {
                return "sum";
            }
        };
    }


    @Override
    public FunctionNode newInstance() {
        return new SUM();
    }
}
