package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    String id;

    @Override
    public void init(ArrayList<String> args) {
        id = args.get(0);

    }

    @Override
    public void execute(VirtualMachine vm) {
        if ("ON".equals(id)) {
            vm.setRunning(true);
        } else if ("OFF".equals(id)) {
            vm.setRunning(false);
        }
    }

    public String toString(){
        return "DUMP ";
    }
}
