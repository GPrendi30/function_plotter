package com.mathparser.instruction.doubleinstruction;

import com.mathparser.instruction.Instruction;
import com.mathparser.program.Storage;

/**
 * BIPUSH pushes the given value onto the operand stack.
 */
public class BDPUSH implements Instruction {

    private final double value;

    /**
     * Creates a new BIPUSH node.
     *
     * @param value a int
     */
    public BDPUSH(final double value) {
        super();
        this.value = value;
    }

    @Override
    public void execute(final Storage storage) {
        storage.getOperandStack().dpush(value);
    }

    @Override
    public String toString() {
        return "BDPUSH " + value;
    }

}
