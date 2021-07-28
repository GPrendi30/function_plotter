package src.main.java.com.mathparser.instruction.intInstruction;

/**
 * src.main.java.com.mathparser.instruction.intInstruction.BIPUSH pushes the given value onto the operand stack.
 */
public class BIPUSH implements Instruction {
    
    private final int value;
    
    /**
     * Creates a new src.main.java.com.mathparser.instruction.intInstruction.BIPUSH node.
     * @param value a int
     */
    public BIPUSH(final int value) {
        super();
        this.value = value;
    }
    
    @Override
    public void execute(final Storage storage) {
        storage.getOperandStack().ipush(value);
    }
    
    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.intInstruction.BIPUSH " + value;
    }

}
