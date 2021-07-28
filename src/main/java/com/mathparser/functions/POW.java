package src.main.java.com.mathparser.functions;

public class POW extends FunctionNode {

    /**
     * Creates a src.main.java.com.mathparser.functions.POW function. power of x function.
     */
    public POW() {
        super("src.main.java.com.mathparser.functions.SUM", 2);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                final double a = op.dpop();
                final double b = op.dpop();
                op.dpush(Math.pow(b, a));
            }

            @Override
            public String toString() {
                return "pow";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new POW();
    }

}
