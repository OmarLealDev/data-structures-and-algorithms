package linked_lists.singly;

import java.util.Scanner;

import linked_lists.LinkedListEmptyException;

public class LinkedListHandler {
    static Scanner scanner = new Scanner(System.in);

    public static void read(LinkedList linkedList){
        linkedList.read();
    }

    public static void readRecursive(LinkedList linkedList){
        linkedList.read();
    }
    
    public static void addElementAtBegining(LinkedList linkedList){
        while (true) {
            try{
                System.out.println("insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                linkedList.addFirst(newValue);
                System.out.println("Element added");
                break;
            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }catch(IndexOutOfBoundsException e){
                System.err.println("Position out of bounds");
            }
        }
    }

    public static void addElementAtNPosition(LinkedList linkedList){
        
        while (true) {
            try {
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                System.out.println("Insert the position (Rembember that the first position is 0)");
                int position = Integer.parseInt(scanner.nextLine());
                linkedList.addElementAtNPosition(newValue, position);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Position out of bounds");
            }
        }
    }

    public static void addElementAtEnd(LinkedList linkedList){
         while (true) {
            try {
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                linkedList.addElementAtEnd(newValue);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }  catch (IndexOutOfBoundsException e) {
                System.err.println("Position out of bounds");
            }
        }
    }

    public static void updateAnElement(LinkedList linkedList){
         while(true) {
            try {

                System.out.println("Insert the new value");
                int newValue = Integer.parseInt(scanner.nextLine());
                System.out.println("Insert the position (Rembember that the first position is 0)");
                int position = Integer.parseInt(scanner.nextLine());
                linkedList.updateAnElement(newValue, position);
                System.out.println("Element updated");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }  catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } catch (LinkedListEmptyException e) {
                System.err.println(e.getMessage());
                break;
            }
        }
    }
    public static void deleteAnElement(LinkedList linkedList) {
        while (true) { 
            try {
                System.out.println("Insert the position (Rembember that the first position is 0)");
                int position = Integer.parseInt(scanner.nextLine());
                linkedList.deleteAnElement(position);
                System.out.println("Element deleted");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }  catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } catch (LinkedListEmptyException e) {
                System.err.println(e.getMessage());
                break;
            }
        }
    }

    public static void reversed(LinkedList linkedList){
        linkedList.reversed();
    }

    public static void reversedRecursive(LinkedList linkedList){
        try {
            linkedList.reversedRecursive(linkedList.head);
        } catch (LinkedListEmptyException e) {
            System.err.println(e.getMessage());
        }    
    }
    public static void showMenu() {
        String dash = "-".repeat(35) + "\n";
        System.out.println(dash);
        System.out.println("1. Read linked list");
        System.out.println("2. Read recursive linked list");
        System.out.println("3. Insert an element at the begining of linked list");
        System.out.println("4. Insert an element at N position of linked list");
        System.out.println("5. Insert an element at the end of linked list");
        System.out.println("6. Update an element of linked list");
        System.out.println("7. Delete an element of linked list");
        System.out.println("8. Reversed linked list");
        System.out.println("9. Reversed recursive linked list");
        System.out.println("10. Find merge point of two linked lists");
        System.out.println(dash);
    }



    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("\nWhat do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> LinkedListHandler.read(linkedList);
                    case 2 -> LinkedListHandler.readRecursive(linkedList);
                    case 3 -> LinkedListHandler.addElementAtBegining(linkedList);
                    case 4 -> LinkedListHandler.addElementAtNPosition(linkedList);
                    case 5 -> LinkedListHandler.addElementAtEnd(linkedList);
                    case 6 -> LinkedListHandler.updateAnElement(linkedList);
                    case 7 -> LinkedListHandler.deleteAnElement(linkedList);
                    case 8 -> LinkedListHandler.reversed(linkedList);
                    case 9 -> LinkedListHandler.reversedRecursive(linkedList);
                    // case 10 -> LinkedListHandler.findMergePoint();
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();
    }
}
