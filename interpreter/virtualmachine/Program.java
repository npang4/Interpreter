package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    private static HashMap<String, Integer> list = new HashMap<String, Integer>();

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {

        // 1st pass through the arraylist keeping track of label codes and their labels
        // 2nd pass through arraylist look for call, goto, and falsebranch codes and do the following:
        // look at stored label codes and find the one that has the matching label value;

        for (int i = 0; i < program.size(); i++) {

            if (program.get(i) instanceof LabelCode) {
                LabelCode lc = (LabelCode) program.get(i);
                list.put(lc.getLabel(), i);
            }
        }

        for (ByteCode byteCode : program) {
            if (byteCode instanceof CallCode) {
                CallCode cc = (CallCode) byteCode;
                cc.setValue(list.get(cc.getLabel()));
            } else if (byteCode instanceof GotoCode) {
                GotoCode gc = (GotoCode) byteCode;
                gc.setValue(list.get(gc.getLabel()));
            } else if (byteCode instanceof FalseBranchCode) {
                FalseBranchCode fbc = (FalseBranchCode) byteCode;
                fbc.setValue(list.get(fbc.getLabel()));
            }
        }
    }

    public void add(ByteCode bc) {
        program.add(bc);
    }


}
