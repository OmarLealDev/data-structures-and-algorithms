package linked_lists.circular_doubly;

import java.util.Scanner;

import linked_lists.LinkedListEmptyException;

public class LinkedListHandler {
   static Scanner scanner = new Scanner(System.in);

    public static void addElementAtBegining(LinkedListDoublyCircular linkedList){
        
        while (true) {
            try{
                System.out.println("Insert the new element");
                int value = Integer.parseInt(scanner.nextLine());
                linkedList.addFirst(value);
                System.out.println("Element added");
                break;
            }
            catch(NumberFormatException e){
                System.err.println("Type an integer");
            }catch(IndexOutOfBoundsException e){
                System.err.println("Position out of bounds");
            }
        }
    }

    public static void addElementAtNPosition(LinkedListDoublyCircular linkedList){
        while (true) {
            try{
                System.out.println("Insert the position");
                int position = Integer.parseInt(scanner.nextLine());
                System.out.println("Insert the new value (Remember that the first position is 0)");
                int value = Integer.parseInt(scanner.nextLine());
                linkedList.addElementAtNPosition(value, position);
                System.out.println("Element added");
                break;
            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }catch(IndexOutOfBoundsException e){
                System.err.println("Position out of bounds");
            }
        }
    }
    
    public static void addElementAtEnd(LinkedListDoublyCircular linkedList){
        while (true) {
            try{
                System.out.println("Insert the new element");
                int value = Integer.parseInt(scanner.nextLine());
                linkedList.addElementAtEnd(value);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }  catch (IndexOutOfBoundsException e) {
                System.err.println("Position out of bounds");
            }
        }
    }

    public static void read(LinkedListDoublyCircular linkedList){
        linkedList.read();
    }

    public static void readRecursive(LinkedListDoublyCircular linkedList){

    }

    public static void updateAnElement(LinkedListDoublyCircular linkedList){
        while (true) {
            try{
                System.out.println("Insert the position to update (Remember that the first position is 0)");
                int position = Integer.parseInt(scanner.nextLine());
                System.out.println("Insert the new value");
                int value = Integer.parseInt(scanner.nextLine());
                linkedList.updateAnElement(value, position);
                System.out.println("Element updated");
                break;

            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }catch(IndexOutOfBoundsException e){
                System.err.println("Position out of bounds");
            }
        }
    }

    public static void deleteAnElement(LinkedListDoublyCircular linkedList){
        while(true){
            try{
                System.out.println("Insert the position of element to delete (Remember the list start in position 0)");
                int position = Integer.parseInt(scanner.nextLine());
                linkedList.deleteAnElement(position);
                System.out.println("Element deleted");
                break;
            }catch(IndexOutOfBoundsException e)
            {
                System.err.println("Position out of bounds");
            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }

        }
    }

    public static void reversed(LinkedListDoublyCircular linkedList){
        linkedList.reversed();
    }

    public static void reversedRecursive(LinkedListDoublyCircular linkedList){
    try{
        linkedList.reversedRecursive();
    }catch(LinkedListEmptyException e){
            System.err.println(e.getMessage());
    }
    }



    public static void showMenu(){
        StringBuilder sd = new StringBuilder().repeat("-", 50);

        System.out.println(sd);
        System.out.println("1. Read the linked list");
        System.out.println("2. Read recursive linked list");
        System.out.println("3. Insert an element at the begining of linked list");
        System.out.println("4. Insert an element at N position of linked list");
        System.out.println("5. Insert an element at the end of linked list");
        System.out.println("6. Update an element of linked list");
        System.out.println("7. Delete an element of the list");
        System.out.println("8. Reversed linked list");
        System.out.println("9. Reversed recursive linked list");
        System.out.println(sd);
    }

    public static void main(String[] args) {

        LinkedListDoublyCircular linkedListDoublyCircular = new LinkedListDoublyCircular();
        final int SALIR = 0;

        int option = 0;

        do{
            System.out.println("\nWhat do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> read(linkedListDoublyCircular);
                    case 2 -> readRecursive(linkedListDoublyCircular);
                    case 3 -> addElementAtBegining(linkedListDoublyCircular);
                    case 4 -> addElementAtNPosition(linkedListDoublyCircular);
                    case 5 -> addElementAtEnd(linkedListDoublyCircular);
                    case 6 -> updateAnElement(linkedListDoublyCircular);
                    case 7 -> deleteAnElement(linkedListDoublyCircular);
                    case 8 -> reversed(linkedListDoublyCircular);
                    case 9 -> reversedRecursive(linkedListDoublyCircular);
                    // case 10 -> findMergePoint();
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }        
        }while(option != SALIR);
        scanner.close();
    }
}
