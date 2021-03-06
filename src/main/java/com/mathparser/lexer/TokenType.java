package com.mathparser.lexer;

/**
 * A program in a programming language is made up
 * of different kinds of tokens.
 * This enumeration represents these different kinds.
 */
public enum TokenType {

    IDENTIFIER("identifier"),

    INTLITERAL("intLiteral"),
    DOUBLELITERAL("doubleLiteral"),
    PLUS("plus"),
    MINUS("minus"),
    STAR("star"),
    SLASH("slash"),
    PERCENT("percent"),
    SIN("sin"),
    FUNCTION("function"),
    OPEN_PAREN("open parenthesis"),
    CLOSED_PAREN("closed parenthesis"),
    COMMA(","),
    END_OF_FILE("end of file");


    private final String name;


    /**
     * Initialize a src.main.java.com.mathparser.lexer.TokenType.
     *
     * @param name The human-readable name of this src.main.java.com.mathparser.lexer.TokenType.
     */
    TokenType(final String name) {
        this.name = name;
    }

    /**
     * Get the human-readable name.
     *
     * @return the name of this src.main.java.com.mathparser.lexer.TokenType.
     */
    public String getName() {
        return name;
    }

}
