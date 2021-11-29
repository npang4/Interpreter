package interpreter.virtualmachine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }



    public void dump(){
        int index = 0;
        for (Integer integer : framePointer) {
            System.out.println(runTimeStack.subList(index, integer));
            index = integer;
        }

        System.out.println(runTimeStack.subList(index, runTimeStack.size()));


    }

    public int peek(){
        return this.runTimeStack.get(this.runTimeStack.size()-1);
    }

    public int push(int i){
         this.runTimeStack.add(i);
         return this.peek();

    }

    public int pop () {
        if(!runTimeStack.isEmpty()){
            return this.runTimeStack.remove(this.runTimeStack.size()-1);
        }
        return 0;
    }

    public int store (int offset) {
        int num = this.pop();
        runTimeStack.set(framePointer.peek() + offset, num);

        return num;
    }

    public int load (int offset) {
        int num = this.runTimeStack.get(framePointer.peek() + offset);

        this.runTimeStack.add(num);

        return num;
    }

    public void newFrameAt (int offset) {
        framePointer.push(this.runTimeStack.size() - offset);


    }

    public void popFrame () {

        //1. pop top of RTS
        //2. pop remaing values up until down to frame boundary
        //3. pop frame boundary
        //4. push the return value from 1.

        int popRTS = this.pop();
        int popVal = framePointer.pop();
        for(int i = runTimeStack.size() - 1; i >= popVal; i--){
            this.pop();
        }

        this.push(popRTS);

    }

    public static void main(String[] args) {
        RunTimeStack rs = new RunTimeStack();


        //Testing push method for RunTimeStack
        rs.push(1);
        rs.push(2);
        rs.push(3);
        rs.push(4);
        rs.push(5);
        rs.push(15);

        for(int i = 0; i < rs.runTimeStack.size(); i++){
            System.out.println(rs.runTimeStack.get(i));

        }

        //Testing peek and pop methods
        /*
        rs.push(10);
        System.out.println("Value on top of stack: " + rs.peek());
        rs.pop();
        System.out.println("Value popped off stack: " + rs.peek());
        */
        //Testing store method


        //Testing load method
        rs.framePointer.push(3);
        rs.load(2);
        System.out.println("-----------------------");
        for(int i = 0; i < rs.runTimeStack.size(); i++){
            System.out.println(rs.runTimeStack.get(i));

        }

    }

}
