package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    int value;
    String id;

    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty()){
            id = args.get(0);
        }


    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.popFrame();
        vm.setProgramCounter(vm.returnAddressPop());

    }

    @Override
    public String toString() {
        String base = "RETURN ";
        if(id != null){
            base += (value + " EXIT " + id + " : " + value + "\n");
        }

        return base;
    }
}
