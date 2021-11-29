package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;
import interpreter.operators.Operator;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    String exp;

    @Override
    public void init(ArrayList<String> args) {
        exp = args.get(0);

    }

    @Override
    public void execute(VirtualMachine vm) {
        int pop2 = vm.pop();
        int pop1 = vm.pop();
        int result = 0;
        Operator op = Operator.getOperator(exp);

        if ("+".equals(exp)) {
            result = op.execute(pop1, pop2);

        } else if ("-".equals(exp)) {
            result = op.execute(pop1, pop2);

        } else if ("*".equals(exp)) {
            result = op.execute(pop1, pop2);

        } else if ("/".equals(exp)) {
            result = op.execute(pop1, pop2);

        } else if ("==".equals(exp)) {
            result = op.execute(pop1, pop2);

        } else if ("!=".equals(exp)) {
            result = op.execute(pop1, pop2);

        } else if ("<=".equals(exp)) {
            result = op.execute(pop1, pop2);
        } else if (">".equals(exp)) {
            result = op.execute(pop1, pop2);


        } else if (">=".equals(exp)) {
            result = op.execute(pop1, pop2);


        } else if ("<".equals(exp)) {
            result = op.execute(pop1, pop2);


        } else if ("|".equals(exp)) {
            result = op.execute(pop1, pop2);


        } else if ("&".equals(exp)) {
            result = op.execute(pop1, pop2);
        }

        vm.push(result);


    }

    public String toString() {
        return "BOP " + " " + exp + "\n[]";
    }
}
