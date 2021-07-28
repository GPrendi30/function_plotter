package src.main.java.com.mathparser.functions;

public interface FunctionInstruction extends Instruction {

    @Override
    public abstract void execute(final Storage storage);

    @Override
    public abstract String toString();
}
