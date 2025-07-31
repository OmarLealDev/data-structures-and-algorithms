package data_structure.hash_tables;

import java.util.Scanner;

public class HashMap {
    static Scanner scanner = new Scanner(System.in);

    public static void print(HashTable<String, Integer>  hashTable) {
        hashTable.print();
    }

    public static void put(HashTable<String, Integer> hashTable) {
        while (true) { 
            try {
                System.out.println("Insert the key of the new element");
                String key = scanner.nextLine();
                System.out.println("Insert the value of the new element");
                int value = Integer.parseInt(scanner.nextLine());
                hashTable.put(key, value);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }
        }
    }

    public static void get(HashTable<String, Integer>  hashTable) {
        System.out.println("Insert the key of the element you want to get");
        String key = scanner.nextLine();
        Integer element = hashTable.get(key);
        if (element == null) {
            System.out.println("The element doesn't exist");
        } else {
            System.out.println("The value of the element is: "+ element);
        }
    }

    public static void remove(HashTable<String, Integer>  hashTable) {
        System.out.println("Insert the key of the element you want to remove");
        String key = scanner.nextLine();
        hashTable.remove(key);
    }

    public static void showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Print Hash Table");
        System.out.println("2. Put an element");
        System.out.println("3. Get an element");
        System.out.println("4. Remove an element");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        HashTable<String, Integer> hashTable = new HashTable<>(5);

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("What do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> HashMap.print(hashTable);
                    case 2 -> HashMap.put(hashTable);
                    case 3 -> HashMap.get(hashTable);
                    case 4 -> HashMap.remove(hashTable);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }
}
