package src.main.java.com.mathparser.instruction.intInstruction;

public class I2D implements Instruction {
    
    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final int val = stack.ipop();
        stack.dpush(val);
    }
    
    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.intInstruction.I2D";
    }
}
