package stacks.array_implementation;

import java.util.Scanner;

public class StackHandler {
    static Scanner scanner = new Scanner(System.in);


    public static void read(Stack stack){
        stack.read();
    }

    public static void push(Stack stack){
        while (true) {
            try {
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                stack.push(newValue);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }
        }
    }

    public static void pop(Stack stack){
        while (true) {
            try {
                stack.pop();
                System.out.println("Element removed");
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } finally {
                break;
            }
        }
    }

    public static void top(Stack stack){
        while (true) {
            try {
                stack.top();
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }  finally {
                break;
            }
        }
    }

    public static void isEmpty(Stack stack){
        boolean isEmpty = stack.isEmpty();

        if (isEmpty) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }

    public static void showMenu(){
        System.out.println("\n-----------------------------------");
        System.out.println("1. Print stack");
        System.out.println("2. Push an element");
        System.out.println("3. Pop an element");
        System.out.println("4. Top element");
        System.out.println("5. Is empty?");
        System.out.println("-----------------------------------\n");
    }

    public static void main(String[] args) {
        Stack stack = new Stack(2);

        final int SALIR = 0;
        int option = 0;

        do{
            System.out.println("What do you want to do?");
            showMenu();

            try{
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> read(stack);
                    case 2 -> StackHandler.push(stack);
                    case 3 -> StackHandler.pop(stack);
                    case 4 -> StackHandler.top(stack);
                    case 5 -> StackHandler.isEmpty(stack);
                    default -> System.out.println("Option doesn't support");
                }
            }catch(NumberFormatException e){
                System.err.println("Please, choose a right option");
            }
        }while(option != 0);
    }
}
