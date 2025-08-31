package linked_lists.singly;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import linked_lists.LinkedListEmptyException;

public class NativeLinkedList {
        static Scanner scanner = new Scanner(System.in);


    public static void read(LinkedList linkedList){
        if(linkedList.isEmpty()) 
        {
            System.out.println("The list is empty");
            return;
        }
        System.out.print("[ ");
        for(int i = 0; i < linkedList.size(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.print("]");
    }

    public static void readRecursive(LinkedList<Integer> linkedList){
        if(linkedList.isEmpty()) 
        {
            System.out.println("[]");
            return;
        }

        System.out.print("[ ");
        readRecHelper(linkedList.listIterator());   // O(n) y sin get(i) O(n)
        System.out.println("]");
        


    }

    private static void readRecHelper(ListIterator<Integer> it) {
        if (!it.hasNext()) return;            // caso base
        System.out.print(it.next() + " ");    // procesa actual
        readRecHelper(it);                    // procesa resto
    }   

    public static void addFirst(LinkedList linkedList){
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
                linkedList.add(position, newValue);
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
            try{
                System.out.println("insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                linkedList.addLast(newValue);
                System.out.println("Element added");
                break;
            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }catch(IndexOutOfBoundsException e){
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
                linkedList.set(position, newValue);
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
    
    public static void deleteAnElement(LinkedList linkedList){
        while (true) { 
            try {
                System.out.println("Insert the position (Rembember that the first position is 0)");
                int position = Integer.parseInt(scanner.nextLine());
                linkedList.remove(position);
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

    public static void reversed(LinkedList<Integer> linkedList){
        if (linkedList.isEmpty()) { 
            System.out.println("The list is empty, nothing to reverse");
            return;
        }

        Collections.reverse(linkedList);
        System.out.println("List reversed");
    }

    public static void reversedRecursive(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty, nothing to reverse");
            return;
        }
        reverseRec(list);                     // O(n) tiempo, O(n) pila
        System.out.println("List reversed (recursive)");
    }

    private static void reverseRec(LinkedList<Integer> list) {
        if (list.size() <= 1) return;         // caso base
        Integer first = list.removeFirst();   // O(1)
        reverseRec(list);                     // revierte el resto
        list.addLast(first);                  // O(1)
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
        LinkedList<Integer> linkedList = new LinkedList<>();

        final int SALIR = 0;
        int option = 0;

        do{
            System.out.println("\nWhat do you want to do?");
            showMenu();
            try{
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> NativeLinkedList.read(linkedList);
                    case 2 -> NativeLinkedList.readRecursive(linkedList);
                    case 3 -> NativeLinkedList.addFirst(linkedList);
                    case 4 -> NativeLinkedList.addElementAtNPosition(linkedList);
                    case 5 -> NativeLinkedList.addElementAtEnd(linkedList);
                    case 6 -> NativeLinkedList.updateAnElement(linkedList);
                    case 7 -> NativeLinkedList.deleteAnElement(linkedList);
                    case 8 -> NativeLinkedList.reversed(linkedList);
                    case 9 -> NativeLinkedList.reversedRecursive(linkedList);

                
                    default -> System.out.println("Option doesn't support");
                }
            }catch(NumberFormatException e){
                System.err.println("Please, choose a right option.");
            }
        }while(option != SALIR);

        scanner.close();

    }
}
