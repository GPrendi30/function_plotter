package src.main.java.com.mathparser.lexer.program;

/**
 * A src.main.java.com.mathparser.lexer.program.Compiler converts an AST into a compiled src.main.java.com.mathparser.lexer.program.Program.
 */
public class Compiler {
    
    /**
     * Compile the given AST.
     * @param node The root of an AST
     * @return the compiled program
     */
    public Program compile(final Node node) {
        final Program p = new Program();
        node.compile(p);
        return p;
    }
    
}
