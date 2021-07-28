package com.mathparser.functions;

import com.mathparser.ast.Node;
import com.mathparser.ast.NodeException;
import com.mathparser.ast.Type;
import com.mathparser.program.Program;
import java.util.ArrayList;


public class FunctionNode extends Node {

    public static final int NO_LIMIT = -99;

    public static final int NULLARY = 0;
    public static final int UNARY = 1;
    public static final int BINARY = 2;
    public static final int TERTIARY = 3;


    private final String name;
    protected final Type[] argumentTypes;
    protected final ArrayList<Node> parameters;
    protected final FunctionInstruction fop;
    protected int numArguments;

    /**
     * Creates a new src.main.java.com.plotter.Function based on the name and Operation.
     *
     * @param name         a String name for the function.
     * @param numArguments the number of the arguments.
     */
    public FunctionNode(final String name, final int numArguments) {
        super();
        this.name = name;
        parameters = new ArrayList<>();
        this.fop = functionInstruction();
        this.numArguments = numArguments;
        this.argumentTypes = new Type[]{Type.INT, Type.DOUBLE};
    }


    /**
     * Adds an argument to the function.
     *
     * @param arg an argument node.
     * @throws NodeException a src.main.java.com.plotter.Function Exception.
     */
    public void addParameter(final Node arg) throws NodeException {
        if (numArguments != FunctionNode.NO_LIMIT && parameters.size() >= numArguments) {
            throw new NodeException("Number of arguments exceeded");
        }

        checkType(arg.getType());
        parameters.add(arg);
    }

    private void checkType(final Type type) throws NodeException {
        for (final Type t : argumentTypes) {
            if (t.equals(type)) {
                return;

            }
        }
        throw new NodeException("Argument type mismatch");
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }

    @Override
    public boolean isConstant() {
        for (final Node arg : parameters) {
            if (!arg.isConstant()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void compile(final Program p) {
        if (parameters.size() - 1 != numArguments) {
            //throw error
        }

        for (final Node arg : parameters) {
            arg.compile(p);
        }
        p.append(functionInstruction());
    }

    //to be overwritten
    protected FunctionInstruction functionInstruction() {
        return null;
    }


    @Override
    public String toString() {
        // to be implemented in subclasses
        final StringBuilder str = new StringBuilder();
        str.append(name + "(");
        for (final Node arg : parameters) {
            str.append(arg);
            if (parameters.size() > 1) {
                str.append(",");
            }
        }
        if (str.lastIndexOf(",") == str.length() - 1) {
            str.delete(str.length() - 1, str.length());
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Get the functionOperation(what the function does)
     *
     * @return the FunctionOperation of a function.
     */
    public FunctionInstruction getFunctionOperation() {
        return fop;
    }

    /**
     * Get the name of the function.
     *
     * @return a String name of a function.
     */
    public String getName() {
        return name;
    }

    /**
     * Creates a new Instance of a functionNode
     *
     * @return a new Instance of a function.
     */
    public FunctionNode newInstance() {
        return null; // to be overridden.
    }


}
