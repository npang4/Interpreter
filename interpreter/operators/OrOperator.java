package interpreter.operators;

public class OrOperator extends Operator{


    @Override
    public int execute(int operandOne, int operandTwo) {

        if(operandTwo != 0 || operandOne != 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
