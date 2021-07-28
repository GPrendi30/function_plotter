package src.main.java.com.plotter;

public class FunctionException extends Exception {

    /**
     * Creates a new src.main.java.com.plotter.FunctionException.
     */
    public FunctionException() {
        super();
    }

    /**
     * Creates a src.main.java.com.plotter.FunctionException with a message.
     * @param message a message thrown together with an Exception.
     */
    public FunctionException(final String message) {
        super(message);
    }

    /**
     * Creates a src.main.java.com.plotter.FunctionException with a message and a cause.
     * @param message a String message thrown with the exception.
     * @param cause the cause of the Exception.
     */
    public FunctionException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
