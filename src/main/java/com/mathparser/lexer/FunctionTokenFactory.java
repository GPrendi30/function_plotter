package com.mathparser.lexer;

public class FunctionTokenFactory extends StringTokenFactory {

    private final TokenType tokenType;


    /**
     * A Factory for functions
     *
     * @param function a String representing a function keyword.
     */
    public FunctionTokenFactory(final String function) {
        super(function);
        this.tokenType = TokenType.FUNCTION;
    }

    @Override
    public Token getToken() {
        // return a token of this object's src.main.java.com.mathparser.lexer.TokenType
        // with its text and starting position
        return new Token(tokenType, getTokenText(), getTokenStartPosition());
    }
}
