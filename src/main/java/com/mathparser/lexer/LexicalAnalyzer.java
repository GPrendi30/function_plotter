package com.mathparser.lexer;

import com.mathparser.parser.ArithSyntaxException;
import java.util.Arrays;

/**
 * A src.main.java.com.mathparser.lexer.LexicalAnalyzer breaks a String into Tokens.
 *
 * <pre>
 * lexer.fetchNextToken();
 * </pre>
 */
public final class LexicalAnalyzer {

    private Token token;
    private String text;
    private int position;
    private final TokenFactory[] tokenFactories;


    /**
     * Create an analyzer for the given text,
     * using the given factories to recognize and create tokens.
     *
     * @param expression The text to analyze
     * @param factories  The token factories to use
     */
    public LexicalAnalyzer(final String expression, final TokenFactory[] factories) {
        tokenFactories = Arrays.copyOf(factories, factories.length);
        setText(expression);
    }

    /**
     * Create an analyzer for the given text.
     *
     * @param expression The text to analyze
     */
    public LexicalAnalyzer(final String expression) {
        this(expression, new TokenFactory[]{
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.SIN"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.COS"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.SUM"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.ABS"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.AVG"),
                new FunctionTokenFactory("MAX"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.MIN"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.MOD"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.POW"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.LOG"),
                new FunctionTokenFactory("src.main.java.com.mathparser.functions.EXP"),
                new IdentifierTokenFactory(),
                new LiteralTokenFactory(),
                new OperatorTokenFactory("+", TokenType.PLUS),
                new OperatorTokenFactory("-", TokenType.MINUS),
                new OperatorTokenFactory("*", TokenType.STAR),
                new OperatorTokenFactory("/", TokenType.SLASH),
                new OperatorTokenFactory("%", TokenType.PERCENT),
                new OperatorTokenFactory("(", TokenType.OPEN_PAREN),
                new OperatorTokenFactory(")", TokenType.CLOSED_PAREN),
                new OperatorTokenFactory(",", TokenType.COMMA),
        });
    }

    /**
     * Provide a new text to analyze.
     *
     * @param expression The text to analyze
     */
    public void setText(final String expression) {
        token = null;
        text = expression;
        position = 0;
        for (final TokenFactory factory : tokenFactories) {
            factory.setText(expression);
        }
    }

    /**
     * Ask the analyzer to move to the next token in the text.
     *
     * @throws ArithSyntaxException a src.main.java.com.mathparser.lexer.LexicalAnalyzer exception.
     */
    public void fetchNextToken() throws ArithSyntaxException {
        token = scanToken();
    }

    /**
     * Scan the text and extract the next token.
     *
     * @return the next token
     * @throws Exception;
     */
    private Token scanToken() throws ArithSyntaxException {
        if (position == text.length()) {
            return new Token(TokenType.END_OF_FILE, "", position);
        } else {
            int maxLength = 0;
            TokenFactory factoryWithLongestMatch = null;

            // Utilize the tokenFactories to find a factory has the longest match
            for (final TokenFactory factory : tokenFactories) {
                if (factory.find(position)) {
                    if (factory.getTokenLength() > maxLength) {
                        factoryWithLongestMatch = factory;
                        maxLength = factory.getTokenLength();
                    }
                }
            }

            // if no match is found then return null, otherwise produce a token
            if (factoryWithLongestMatch == null) {
                throw new ArithSyntaxException("Unrecognized character at position "
                        + (position + 1));
            } else {
                position += factoryWithLongestMatch.getTokenLength();
                return factoryWithLongestMatch.getToken();
            }
        }
    }

    /**
     * Get the current token.
     *
     * @return the current token
     */
    public Token getCurrentToken() {
        return token;
    }

}
