package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private Program program;
    private int programCounter;
    private boolean isRunning;
    private boolean dumping;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public RunTimeStack getRunTimeStack() {
        return runTimeStack;
    }

    public Stack<Integer> getReturnAddress() {
        return returnAddress;
    }

    public Program getProgram() {
        return program;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public int push(int i) {
        return runTimeStack.push(i);
    }

    public int pop() {
        return runTimeStack.pop();
    }

    public void pushReturnAddress() {
        returnAddress.push(programCounter);
    }

    public int peek() {
        return runTimeStack.peek();
    }

    public int store(int i) {
        return runTimeStack.store(i);
    }

    public void load(int offset) {
        runTimeStack.load(offset);
    }

    public void newFrameAt(int i) {
        runTimeStack.newFrameAt(i);
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public int returnAddressPop() {
        return returnAddress.pop();
    }

    public void isDumping(ByteCode bc){
        if(dumping){
            System.out.println(bc.toString());
            runTimeStack.dump();
        }
    }


    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        //dumping = true;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            //isDumping(code);          //Dumping for debugging
            programCounter++;
        }

    }



}
