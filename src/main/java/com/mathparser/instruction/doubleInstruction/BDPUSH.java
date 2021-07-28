package src.main.java.com.mathparser.instruction.doubleInstruction;

/**
 * src.main.java.com.mathparser.instruction.intInstruction.BIPUSH pushes the given value onto the operand stack.
 */
public class BDPUSH implements Instruction {
    
    private final double value;
    
    /**
     * Creates a new src.main.java.com.mathparser.instruction.intInstruction.BIPUSH node.
     * @param value a int
     */
    public BDPUSH(final double value) {
        super();
        this.value = value;
    }
    
    @Override
    public void execute(final Storage storage) {
        storage.getOperandStack().dpush(value);
    }
    
    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.doubleInstruction.BDPUSH " + value;
    }

}
