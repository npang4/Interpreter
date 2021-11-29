package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadCode extends ByteCode{
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int num = scan.nextInt();
        vm.push(num);

    }

    public String toString(){
        return "READ \n[]";
    }
}
