package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {

    private int value;
    private String id;
    private String offset;

    @Override
    public void init(ArrayList<String> args) {
        offset = args.get(0);
        if(args.size() > 1){
            id = args.get(1);
        }

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(Integer.parseInt(offset));
        value = vm.peek();
    }

    @Override
    public String toString() {
        return "STORE " + offset + " " + id + " " + id + "=" + value + "\n[]";
    }
}
