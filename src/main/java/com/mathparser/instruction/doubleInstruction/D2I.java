package src.main.java.com.mathparser.instruction.doubleInstruction;

public class D2I implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final double val = stack.ipop();
        stack.ipush((int) val);
    }

    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.doubleInstruction.D2I";
    }
    
}
