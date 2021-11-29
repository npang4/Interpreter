package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode{

    String id;
    int value;

    @Override
    public void init(ArrayList<String> args) {
        id = args.get(0);

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(value);

    }

    public String getLabel() {
        return id;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        return "GOTO " + id + "\n[]";
    }
}


