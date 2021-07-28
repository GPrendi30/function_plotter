package src.main.java.com.mathparser.functions;

public class MIN extends FunctionNode {

    /**
     * Creates a new src.main.java.com.mathparser.functions.MIN function.
     */
    public MIN() {
        super("src.main.java.com.mathparser.functions.LOG", 2);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                op.dpush(Math.min(op.dpop(), op.dpop()));
            }

            @Override
            public String toString() {
                return "min";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new MIN();
    }
}
