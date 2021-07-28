package src.main.java.com.mathparser.lexer;

/**
 * A special kind of src.main.java.com.mathparser.lexer.RegExTokenFactory that produces tokens
 * that are integer literals.
 */
public class LiteralTokenFactory extends RegExTokenFactory {

    /**
     * Create a new src.main.java.com.mathparser.lexer.LiteralTokenFactory.
     */
    public LiteralTokenFactory() {
        // regular expression for an integer literal
        super("[0-9]*\\.?[0-9]+");
    }

    @Override
    public Token getToken() {
        // return a token of the appropriate src.main.java.com.mathparser.lexer.TokenType
        // with its text and starting position

        final String tokenContent = getTokenText();
        final int position = getTokenStartPosition();
        return  tokenContent.contains(".")
                ?  new Token(TokenType.DOUBLELITERAL, tokenContent, position)
                :  new Token(TokenType.INTLITERAL, tokenContent, position);
    }

}
