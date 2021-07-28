package src.main.java.com.mathparser.lexer.program;

/**
 * The src.main.java.com.mathparser.lexer.program.OperandStack is a stack holding
 * the temporary values during execution.
 * (If you took Computer Architecture at USI,
 * you should remember this).
 */
public class OperandStack {
    
    private final Double[] stack;
    private int sp;
    
    /**
     * Create an empty src.main.java.com.mathparser.lexer.program.OperandStack.
     * with space for at most 10 elements!
     */
    public OperandStack() {
        stack = new Double[10];
        sp = -1;
    }

    /**
     * Push the given value on the stack.
     * @param value The value to ipush
     */
    public void ipush(final int value) {
        stack[++sp] = (double) value; 
    }
    
    /**
     * Push the given value on the stack.
     * @param value The value to ipush
     */
    public void dpush(final double value) {
        stack[++sp] = value; 
    }

    /**
     * Pop the top-most value off the stack.
     * @return the top-most value
     */
    public int ipop() {
        return stack[sp--].intValue();
    }

    /**
     * Pop the top-most value off the stack.
     * @return the top-most value
     */
    public double dpop() {
        return stack[sp--];
    }
    
}
