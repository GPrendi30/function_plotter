package src.main.java.com.mathparser.parser;

public class ArithSyntaxException extends Exception {

    /**
     * Creates a new src.main.java.com.mathparser.parser.ArithSyntaxException.
     */
    public ArithSyntaxException() {
        super();
    }

    /**
     * Creates a src.main.java.com.mathparser.parser.ArithSyntaxException with a message.
     * @param message a message thrown together with an Exception.
     */
    public ArithSyntaxException(final String message) {
        super(message);
    }

    /**
     * Creates a src.main.java.com.mathparser.parser.ArithSyntaxException with a message and a cause.
     * @param message a String message thrown with the exception.
     * @param cause the cause of the Exception.
     */
    public ArithSyntaxException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
