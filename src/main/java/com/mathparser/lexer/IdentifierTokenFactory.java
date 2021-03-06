package com.mathparser.lexer;//---

/**
 * A factory for tokens of type identifier.
 */
public class IdentifierTokenFactory extends RegExTokenFactory {

    /**
     * Create an src.main.java.com.mathparser.lexer.IdentifierTokenFactory.
     */
    public IdentifierTokenFactory() {
        super("[a-zA-Z_][a-zA-Z_0-9]*");
    }

    /**
     * Produce a token.
     *
     * @return the currently found token
     */
    public Token getToken() {
        return new Token(TokenType.IDENTIFIER, getTokenText(), getTokenStartPosition());
    }

}
//---