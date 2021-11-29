package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {

    int value;

    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < value; i++) {
            vm.pop();
        }
    }

    public String toString() {
        return "POP: " + value + "\n";
    }
}
