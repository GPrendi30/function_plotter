package src.main.java.com.mathparser.functions;

public class ABS extends FunctionNode {

    /**
     * Creates a new src.main.java.com.mathparser.functions.ABS function.
     */
    public ABS() {
        super("src.main.java.com.mathparser.functions.LOG", 1);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                final double a = op.dpop();
                op.dpush(a < 0 ? -a : a);
            }

            @Override
            public String toString() {
                return "abs";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new ABS();
    }

}
