package src.main.java.com.plotter;

import java.util.ArrayList;
import src.main.java.com.mathparser.ast.Node;
import src.main.java.com.mathparser.parser.ArithParser;
import src.main.java.com.mathparser.parser.ArithSyntaxException;
import src.main.java.com.mathparser.parser.Parser;
import src.main.java.com.mathparser.lexer.program.Program;
import src.main.java.com.mathparser.lexer.program.VariableTable;


/**
 * The src.main.java.com.plotter.Function is the most important part of the "model"
 * in our function plotter application.
 * The "model" does not know anything about the "GUI".
 * It could exist without "GUI" (e.g., for a command-line interface).
 */
public final class Function {

    private final ArrayList<FunctionListener> listeners;
    private String expressionText;
    private Program program;
    private boolean drawable;
    private Range range;
    
    /**
     * Create a src.main.java.com.plotter.Function based on the given expression.
     * @param expressionText The expression (a function of x).
     * @throws FunctionException throws src.main.java.com.plotter.FunctionException if the expression can't be parsed.
     */
    public Function(final String expressionText) throws FunctionException {
        listeners = new ArrayList<>();
        setExpression(expressionText);
        drawable = true;
        range = new Range(0,0);
    }
    
    /**
     * Change the expression underlying this src.main.java.com.plotter.Function.
     * @param expressionText The new expression (a function of x).
     * @throws FunctionException throws src.main.java.com.plotter.FunctionException if the expression can't be parsed.
     */
    public final void setExpression(final String expressionText) throws FunctionException {
        this.expressionText = expressionText;
        final Parser parser = new ArithParser();
        final Node parsedExpression;
        try {
            parsedExpression = parser.parse(expressionText);
            program = new Program();
            parsedExpression.compile(program);
            fireFunctionChanged();
        } catch (ArithSyntaxException exception) {
            throw new FunctionException(exception.getMessage(), exception);
        }

    }

    /**
     * Set min in the function range.
     * @param min double min of the range.
     */
    public final void setMin(final double min) {
        range.setMin(min);
        fireFunctionChanged();
    }

    /**
     * Set max in the function range.
     * @param max double max of the range.
     */
    public final void setMax(final double max) {
        range.setMax(max);
        fireFunctionChanged();
    }

    /**
     * Get the expression defining this function.
     * @return the expression.
     */
    public final String getExpression() {
        return expressionText;
    }

    /**
     * Get the function range.
     * @return the function range.
     */
    public final Range getRange() {
        return range;
    }

    /**
     * Evaluate the function at the given x.
     * @param x The value in which to evaluate the function.
     * @return the value of the function in the given x.
     */
    public final double compute(final double x) {
        final VariableTable variableTable = new VariableTable();
        final double value = x;
        variableTable.dset("x", value);
        return program.dExecute(variableTable);
    }

    /**
     * Checks if the function is drawable.
     * @return true if drawable, else false.
     */
    public boolean isDrawable() {
        return drawable;
    }

    /**
     * Set the drawable state.
     * @param drawable a boolean.
     */
    public void setDrawable(final boolean drawable) {
        this.drawable = drawable;
        fireFunctionChanged();
    }
    //--- listener management

    /**
     * Adds a new function listener.
     * @param li a src.main.java.com.plotter.Function Listener
     */
    public void addFunctionListener(final FunctionListener li) {
        listeners.add(li);
    }

    /**
     * Removes a function listener.
     * @param li a src.main.java.com.plotter.Function Listener
     */
    public void removeFunctionListener(final FunctionListener li) {
        listeners.remove(li);
    }
    
    private void fireFunctionChanged() {
        for (final FunctionListener fi : listeners) {
            fi.functionChanged(this);
        }
    }

    /**
     * Set the range to plot the function.
     * @param min double min of the range.
     * @param max double max of the range.
     */
    public void setRange(final double min, final double max) {
        range = new Range(min, max);
    }
}