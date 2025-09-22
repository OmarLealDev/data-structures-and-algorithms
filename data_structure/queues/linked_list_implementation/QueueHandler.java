package queues.linked_list_implementation;

import java.util.Scanner;

public class QueueHandler {
    static Scanner scanner = new Scanner(System.in);

    public static void read(Queue queue){
        queue.read();
    }

    public static void enqueue(Queue queue){
        while (true) {
            try {
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                queue.enqueue(newValue);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
                break;
            }
        }
    }

    public static void dequeue(Queue queue){
        while (true) {
            try {
                queue.dequeue();
                System.out.println("Element removed");
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } finally {
                break;
            }
        }
    }

    public static void front(Queue queue){
        while (true) {
            try {
                queue.front();
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }  finally {
                break;
            }
        }
    }

    public static void isEmpty(Queue queue){
        boolean isEmpty = queue.isEmpty();

        if(isEmpty){
            System.out.println("Queue is empty");
        }else{
            System.out.println("Queue is not empty");
        }
    }

    public static void showMenu(){
        System.out.println("\n-----------------------------------");
        System.out.println("1. Print queue");
        System.out.println("2. Enqueue an element");
        System.out.println("3. Dequeue an element");
        System.out.println("4. Front element");
        System.out.println("5. Is empty?");
        System.out.println("-----------------------------------\n");
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        final int SALIR = 0;
        int option = 0;

        do{
            System.out.println("\nWhat do you want to do?");
            showMenu();
            try{
               switch (option) {
                    case 1 -> QueueHandler.read(queue);
                    case 2 -> QueueHandler.enqueue(queue);
                    case 3 -> QueueHandler.dequeue(queue);
                    case 4 -> QueueHandler.front(queue);
                    case 5 -> QueueHandler.isEmpty(queue);
                    default -> System.out.println("Option doesn't support");
                }
            }catch(NumberFormatException e){
                System.err.println("Please, choose a right option");
            }

        }while(option != SALIR);
    }

}
