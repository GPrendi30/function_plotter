package src.main.java.com.mathparser.instruction.intInstruction;

/**
 * src.main.java.com.mathparser.instruction.intInstruction.INEG negates the top value from the src.main.java.com.mathparser.lexer.program.OperandStack
 * and ipushes the result back to the src.main.java.com.mathparser.lexer.program.OperandStack.
 */
public class INEG implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.ipush(-stack.ipop());
    }
    
    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.intInstruction.INEG";
    }

}
