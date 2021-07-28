package src.main.java.com.mathparser.instruction.intInstruction;

public class IMUL implements Instruction {
    
    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.ipush(stack.ipop() * stack.ipop());
    }
    
    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.intInstruction.IMUL";
    }
}
