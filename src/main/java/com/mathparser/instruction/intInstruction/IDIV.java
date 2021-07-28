package src.main.java.com.mathparser.instruction.intInstruction;

public class IDIV implements Instruction {
    
    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.ipush((1 / stack.ipop()) * stack.ipop());
    }

    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.intInstruction.IDIV";
    }
    
}
