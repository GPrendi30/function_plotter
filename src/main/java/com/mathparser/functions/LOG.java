package src.main.java.com.mathparser.functions;

public class LOG extends FunctionNode {

    /**
     * Creates a new src.main.java.com.mathparser.functions.LOG function. logarithm.
     */
    public LOG() {
        super("src.main.java.com.mathparser.functions.LOG", 1);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                op.dpush(Math.log(op.dpop()));
            }

            @Override
            public String toString() {
                return "log";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new LOG();
    }
}
