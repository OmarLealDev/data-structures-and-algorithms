package stacks.array_implementation;

import java.util.Arrays;
import java.util.List;

public class Stack {
    int maxSize;
    int[] stack;
    int top;



    public Stack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    private void createNewArray(){
        System.out.println("Creating new array...");
        int[] newStack = new int[maxSize * 2];
        System.arraycopy(stack, 0, newStack, 0  , maxSize);
        stack = newStack;
        System.out.println("New array created.");
    }

    public void read(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("\nStack element\n");

        // List<int[]> elements = Arrays.asList(stack);

        // elements.stream().forEach(System.out::println);

        for (int i = top; i >= 0 ; i--) {
            System.out.println("| "+ stack[i] +" |");
            System.out.println("|___|");
        }
    }

    public void push(int value){
        if(top == maxSize -1){
            createNewArray();
        }

        stack[++top] = value;
    }

    public void top(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        System.out.println("Top element: " + stack[top]);

    }

    public void pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        stack[top--] = 0;
    }





}
