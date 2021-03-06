package com.mathparser.ast;

public class NodeException extends Exception {

    /**
     * Creates a new src.main.java.com.mathparser.ast.NodeException.
     */
    public NodeException() {
        super();
    }

    /**
     * Creates a src.main.java.com.mathparser.ast.NodeException with a message.
     *
     * @param message a message thrown together with an Exception.
     */
    public NodeException(final String message) {
        super(message);
    }

    /**
     * Creates a src.main.java.com.mathparser.ast.NodeException with a message and a cause.
     *
     * @param message a String message thrown with the exception.
     * @param cause   the cause of the Exception.
     */
    public NodeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}