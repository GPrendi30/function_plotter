package src.main.java.com.mathparser.functions;

public class SIN extends FunctionNode {

    /**
     * Creates a new Sin function. sine.
     */
    public SIN() {
        super("src.main.java.com.mathparser.functions.SIN", 1);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                final double a = op.dpop();
                op.dpush(Math.sin(a));
            }

            @Override
            public String toString() {
                return "sin";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new SIN();
    }
}
