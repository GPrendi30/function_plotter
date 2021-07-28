package src.main.java.com.mathparser.parser;

/** A src.main.java.com.mathparser.parser.Parser for our Arith language
        * (a simple language of arithmetic expressions).
        *
        * <code>
 * EXPRESSION   ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
         * TERM         ::= FACTOR { ( "*" | "/" ) FACTOR }
         * FACTOR       ::= Literal |
         *                  Identifier|
         *                  "(" EXPRESSION ")" |
         *                  FUNCTION
         * FUNCTION     ::= src.main.java.com.mathparser.functions.SIN|src.main.java.com.mathparser.functions.COS|src.main.java.com.mathparser.functions.SUM (EXPRESSION {, EXPRESSION})
         * </code>
        */
public final class ArithParser implements Parser {
    private LexicalAnalyzer lexer;

    /**
     * Parse a program in the Arith language.
     * @param sourceCode The source code of the program in the Arith language
     * @return an AST of the program
     */
    @Override
    public Node parse(final String sourceCode) throws ArithSyntaxException {
        final String src = sourceCode.replace(" ", "");
        this.lexer = new LexicalAnalyzer(src);
        // fetch first token
        lexer.fetchNextToken();
        // now parse the EXPRESSION
        final Node result = parseExpression();

        if (lexer.getCurrentToken().getType() != TokenType.END_OF_FILE) {
            throw new ArithSyntaxException("Extra parenthesis at position "
                    + lexer.getCurrentToken().getStartPosition());
        }
        return result;
    }

    /**
     * Parse an expression.
     * This assumes the lexer already points to the first token of this expression.
     *
     * <p>EBNF:
     * <code>
     * EXPRESSION ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
     * </code>
     *
     * @return a src.main.java.com.mathparser.ast.Node representing the expression
     */
    private Node parseExpression() throws ArithSyntaxException {
        // parses an expression to an AST

        boolean negated = false;
        boolean isAdd = false;

        //checking the optional [+ | -]
        if (lexer.getCurrentToken().getType() == TokenType.MINUS) {
            negated = true;
            lexer.fetchNextToken();
        } else if (lexer.getCurrentToken().getType() == TokenType.PLUS) {
            lexer.fetchNextToken();
        }

        Node left = parseTerm();
        if (negated) {
            left = new GeneralNegation(left);
        }

        // parsing for n number of terms
        while (lexer.getCurrentToken().getType() != TokenType.END_OF_FILE) {
            if (lexer.getCurrentToken().getType() == TokenType.PLUS) {
                isAdd = true;
            } else if (lexer.getCurrentToken().getType() == TokenType.MINUS) {
                isAdd = false;
            } else {
                break;
            }
            lexer.fetchNextToken();

            //parsing right node.
            final Node right = parseTerm();

            left = isAdd
                    ? new GeneralAddition(left, right)
                    : new GeneralSubtraction(left, right);
        }

        return left;
    }

    /**
     * Parse a term.
     * This assumes the lexer already points to the first token of this term.
     *
     * <p>EBNF:
     * <code>
     * TERM ::= FACTOR { ( "*" | "/" ) FACTOR }
     * </code>
     *
     * @return a src.main.java.com.mathparser.ast.Node representing the term
     */
    private Node parseTerm() throws ArithSyntaxException {
        boolean isMul = false;

        Node left = parseFactor();
        while (lexer.getCurrentToken().getType() != TokenType.END_OF_FILE) {

            if (lexer.getCurrentToken().getType() == TokenType.STAR) {
                isMul = true;
                lexer.fetchNextToken();
            } else if (lexer.getCurrentToken().getType() == TokenType.SLASH) {
                lexer.fetchNextToken();
            } else {
                break;
            }

            final Node right = parseFactor();
            left =  isMul
                    ? new GeneralMultiplication(left, right)
                    : new GeneralDivision(left, right);
        }

        return left;
    }

    /**
     * Parse a factor.
     * This assumes the lexer already points to the first token of this factor.
     *
     * <p>EBNF:
     * <code>
     * FACTOR ::=
     *          Literal |
     *          Identifier |
     *          "(" EXPRESSION ")"
     * </code>
     *
     * @return a src.main.java.com.mathparser.ast.Node representing the factor
     */
    private Node parseFactor() throws ArithSyntaxException {

        Node res;
        switch (lexer.getCurrentToken().getType()) {
            case TokenType.DOUBLELITERAL :
                res = new DoubleLiteral(Double.parseDouble(lexer.getCurrentToken().getText()));

                lexer.fetchNextToken();
                break;

            case TokenType.INTLITERAL:
                res = new IntLiteral(Integer.parseInt(lexer.getCurrentToken().getText()));

                lexer.fetchNextToken();
                break;

            case TokenType.IDENTIFIER:
                res = new DoubleVariable(lexer.getCurrentToken().getText());

                lexer.fetchNextToken();
                break;

            case TokenType.OPEN_PAREN:

                lexer.fetchNextToken();

                res = parseExpression();

                if (lexer.getCurrentToken().getType() != TokenType.CLOSED_PAREN) {
                    throw new ArithSyntaxException("Missing parenthesis at position "
                            + lexer.getCurrentToken().getStartPosition());

                }

                lexer.fetchNextToken();
                break;

            case TokenType.FUNCTION:
                res = parseFunction();
                break;

            default:
                throw new ArithSyntaxException("Illegal Character at position "
                        + lexer.getCurrentToken().getStartPosition());
        }

        return res;
    }


    /**
     * Parse a function.
     * This assumes the lexer already points to the first token of this function.
     *
     * <p>EBNF:
     * <code>
     * FUNCTION  ::= src.main.java.com.mathparser.functions.SIN|src.main.java.com.mathparser.functions.COS|src.main.java.com.mathparser.functions.SUM (EXPRESSION {, EXPRESSION})
     * </code>
     * @return a src.main.java.com.mathparser.ast.Node representing the function
     */
    private Node parseFunction() throws ArithSyntaxException {
        final FunctionNode f = parseFunctionKeyword();

        if (lexer.getCurrentToken().getType() != TokenType.OPEN_PAREN) {
            throw new ArithSyntaxException("Was expecting an OPEN PAREN got "
                    + lexer.getCurrentToken().getText());
        }

        lexer.fetchNextToken();


        while (lexer.getCurrentToken().getType() != TokenType.END_OF_FILE) {
            try {
                f.addParameter(parseExpression());
            } catch (NodeException exception) {
                throw new ArithSyntaxException(exception.getMessage(), exception);
            }

            if (lexer.getCurrentToken().getType() != TokenType.COMMA) {
                break;
            }
            lexer.fetchNextToken();
        }

        if (lexer.getCurrentToken().getType() != TokenType.CLOSED_PAREN) {
            throw new ArithSyntaxException("Was expecting a CLOSED PAREN got "
                    + lexer.getCurrentToken().getText());
        }

        lexer.fetchNextToken();
        return f;
    }

    private FunctionNode parseFunctionKeyword() throws ArithSyntaxException {
        final String name = lexer.getCurrentToken().getText();
        for (final DeclaredFunction func : DeclaredFunction.values()) {
            if (name.equals(func.getName())) {
                lexer.fetchNextToken();
                return func.getFunction();
            }
        }

        throw new ArithSyntaxException("Keyword not found, "
                    + lexer.getCurrentToken().getStartPosition());
    }

    private enum DeclaredFunction {

        SUM("src.main.java.com.mathparser.functions.SUM", new SUM()),
        COS("src.main.java.com.mathparser.functions.COS", new COS()),
        SIN("src.main.java.com.mathparser.functions.SIN", new SIN()),
        MIN("src.main.java.com.mathparser.functions.MIN", new MIN()),
        MAX("MAX", new MAX()),
        LOG("src.main.java.com.mathparser.functions.LOG", new LOG()),
        ABS("src.main.java.com.mathparser.functions.ABS", new ABS()),
        AVG("src.main.java.com.mathparser.functions.AVG", new AVG()),
        EXP("src.main.java.com.mathparser.functions.EXP", new EXP()),
        POW("src.main.java.com.mathparser.functions.POW", new POW()),
        MOD("MOS", new MOD());


        private String name;
        private FunctionNode function;

        private DeclaredFunction(final String name, final FunctionNode function) {
            this.name = name;
            this.function = function;
        }

        public FunctionNode getFunction() {
            return function.newInstance();
        }

        public String getName() {
            return name;
        }

    }

}
