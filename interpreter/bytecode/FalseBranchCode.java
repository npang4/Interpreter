package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode{

    String id;
    int value;

    public String getLabel() {
        return id;
    }

    @Override
    public void init(ArrayList<String> args) {

        id = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(vm.pop() == 0){
           vm.setProgramCounter(value);
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        return "FALSEBRANCH " + id + "\n[]";
    }


}
