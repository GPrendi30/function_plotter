package src.main.java.com.mathparser.functions;

public class MOD extends FunctionNode {

    /**
     * Creates a new src.main.java.com.mathparser.functions.MOD function. modulo.
     */
    public MOD() {
        super("src.main.java.com.mathparser.functions.MOD", 2);
    }

    protected FunctionInstruction functionInstruction() {
        return new FunctionInstruction() {
            @Override
            public void execute(final Storage storage) {
                final OperandStack op = storage.getOperandStack();
                final double a = op.dpop();
                final double b = op.dpop();
                final double val = b % a;
                op.dpush(val);
            }

            @Override
            public String toString() {
                return "mod";
            }
        };
    }

    @Override
    public FunctionNode newInstance() {
        return new MOD();
    }

}
