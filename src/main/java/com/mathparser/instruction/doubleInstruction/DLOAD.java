package src.main.java.com.mathparser.instruction.doubleInstruction;

public class DLOAD implements Instruction {

    private final String var;

    /**
     * Creates a new src.main.java.com.mathparser.instruction.intInstruction.ILOAD src.main.java.com.mathparser.instruction.Instruction.
     * @param var a String
     */
    public DLOAD(final String var) {
        super();
        this.var = var;
    }
    
    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final VariableTable variableTable = storage.getVariableTable();
        final double xValue = variableTable.getDouble(var);
        stack.dpush(xValue);
    }

    /**
     * Returns a String.
     * @return a String representation of the src.main.java.com.mathparser.ast.Node
     */
    public String toString() {
        return "src.main.java.com.mathparser.instruction.doubleInstruction.DLOAD " + var;
    }
    
}
