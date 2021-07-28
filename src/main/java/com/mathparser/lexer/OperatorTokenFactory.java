package com.mathparser.lexer;

/**
 * A special kind of src.main.java.com.mathparser.lexer.StringTokenFactory,
 * which produces tokens that represent operators.
 */
public class OperatorTokenFactory extends StringTokenFactory {

    private final TokenType tokenType;


    /**
     * Create an src.main.java.com.mathparser.lexer.OperatorTokenFactory for tokens representing the given operator.
     *
     * @param operator  the operator
     * @param tokenType the src.main.java.com.mathparser.lexer.TokenType corresponding to this operator
     */
    public OperatorTokenFactory(final String operator, final TokenType tokenType) {
        super(operator);
        this.tokenType = tokenType;
    }

    @Override
    public Token getToken() {
        // return a token of this object's src.main.java.com.mathparser.lexer.TokenType
        // with its text and starting position
        return new Token(tokenType, getTokenText(), getTokenStartPosition());
    }

}
