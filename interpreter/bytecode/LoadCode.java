package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{

    int offset;
    String id;

    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size() > 1){
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
       vm.load(offset);
    }

    @Override
    public String toString() {
        String base = "LOAD " + offset + " " + id + "\n[]";
        if(id != null){
            return "LOAD " + offset + " " + id + "\t<load " + id + ">\n[]";
        }

        return base;
    }
}
