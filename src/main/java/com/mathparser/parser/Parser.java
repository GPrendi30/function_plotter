package com.mathparser.parser;

import com.mathparser.ast.Node;

/**
 * A src.main.java.com.mathparser.parser.Parser can convert source code into an AST
 * consisting of src.main.java.com.mathparser.ast.Node objects.
 */
public interface Parser {

    /**
     * Parse the given source code.
     *
     * @param sourceCode The source code of the program
     * @return the AST of the program
     * @throws ArithSyntaxException throws when syntax errors come in.
     */
    Node parse(String sourceCode) throws ArithSyntaxException;

}
