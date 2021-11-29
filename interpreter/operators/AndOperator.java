package interpreter.operators;

public class AndOperator extends Operator{

    @Override
    public int execute(int operandOne, int operandTwo) {

        if(operandTwo != 1 && operandOne != 1){
            return 1;
        }
        else{
            return 0;
        }
    }
}

