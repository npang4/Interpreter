package interpreter.operators;



public class AddOperator extends Operator{


    @Override
    public int execute(int operandOne, int operandTwo) {
        return operandOne + operandTwo;

    }
}
