package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{

    String id;
    int value;

    @Override
    public void init(ArrayList<String> args) {
        id = args.get(0);

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress();
        vm.setProgramCounter(value);

    }

    public String getLabel() {
        return id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return "CALL " + id + "\t" + value + "\n[]";
    }
}
