package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{

    String id;

    @Override
    public void init(ArrayList<String> args) {
        id = args.get(0);

    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.newFrameAt(Integer.parseInt(id));

    }

    @Override
    public String toString() {
        return "\nARGs " + id + "\n[]";
    }
}
