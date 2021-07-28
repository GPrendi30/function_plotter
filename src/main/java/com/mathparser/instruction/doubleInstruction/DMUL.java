package src.main.java.com.mathparser.instruction.doubleInstruction;

public class DMUL implements Instruction {


    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.dpush(stack.dpop() * stack.dpop());
    }

    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.doubleInstruction.DMUL";
    }
    
}
