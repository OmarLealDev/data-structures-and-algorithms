package algorithms.sorting;

import java.util.Scanner;

public class SortingHandler {

    static Scanner scanner = new Scanner(System.in);

    
    private static void print(int[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("\n");
    }

    public static void bubbleSort(Sorting sorting) {
         int[] list = {5, 3, 2, 4, 1};
        System.out.println("List to sort: ");
        print(list);

        sorting.bubble(list);

        System.out.println("List sorted: ");
        print(list);
    }

    public static void selectionSort(Sorting sorting){
        int[] list = {5, 3, 2, 4, 1};
        System.out.println("List to sort: ");
        print(list);

        sorting.selection(list);

        System.out.println("List sorted: ");
        print(list);
    }

    public static void showMenu(){
        System.out.println("---------------------------------");
        System.out.println("1. Selection Sort");
        System.out.println("2. Bubble Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Exit");

    }

    public static void main(String[] args) {
        Sorting sorting = new Sorting();

        final int SALIR = 0;
        int option = -1;

        do{
            System.out.println("What do you want to do?");
            showMenu();
            try{
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> SortingHandler.selectionSort(sorting);
                    case 2 -> SortingHandler.bubbleSort(sorting);
                    // case 3 -> SortingHandler.insertion(sorting);
                    // case 4 -> SortingHandler.merge(sorting);
                    // case 5 -> SortingHandler.quick(sorting);
                    default -> System.out.println("Option doesn't support");
                }
            }catch(Exception e){
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                continue;
            }
        }while(option != SALIR);
    }

}
