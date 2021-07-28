package com.mathparser.functions;

import com.mathparser.program.OperandStack;
import com.mathparser.program.Storage;

public class EXP extends FunctionNode {

    /**
     * Creates a src.main.java.com.mathparser.functions.EXP function. exponential function.
     */
    public EXP() {
        super("src.main.java.com.mathparser.functions.EXP", 2);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                final double exp = Math.exp(op.dpop());
                op.dpush(exp);
            }

            @Override
            public String toString() {
                return "exp";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new EXP();
    }
}
