package src.main.java.com.mathparser.instruction.intInstruction;

/**
 * src.main.java.com.mathparser.instruction.intInstruction.ISUB subtracts the top value from the second-to-top value
 * of the src.main.java.com.mathparser.lexer.program.OperandStack,
 * and ipushes the result back to the src.main.java.com.mathparser.lexer.program.OperandStack.
 */
public class ISUB implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.ipush(-stack.ipop() + stack.ipop());
    }
        
    @Override
    public String toString() {
        return "src.main.java.com.mathparser.instruction.intInstruction.ISUB";
    }

}
