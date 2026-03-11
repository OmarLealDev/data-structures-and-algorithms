import java.util.Scanner;

public class TreesHandler {
    static Scanner scanner = new Scanner(System.in);

    public static void insert(BinarySearchTree bst){
        while (true) {
            try{
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                bst.root = bst.insert(bst.root, newValue);
                System.out.println("Element added");

            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }
        }
    }

    public static void delete(BinarySearchTree bst){
        while (true) {
            try{
                System.out.println("Insert the element to delete");
                int data = Integer.parseInt(scanner.nextLine());
                bst.root = bst.delete(bst.root, data);
                System.out.println("Element deleted");

            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }
        }
    }

    public static void search(BinarySearchTree bst){
        while (true) {
            try{
                System.out.println("Insert the element to search");
                int data = Integer.parseInt(scanner.nextLine());
                boolean exists = bst.search(bst.root, data);
                if (exists) {
                    System.out.println("Element exists");
                }else{
                    System.out.println("Element doesn't exist");
                }
                break;
            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }
        }
    }

    public static void findMin(BinarySearchTree bst) {
        int min = bst.findMin(bst.root);

        if(min == -1) {
            System.out.println("Tree is empty");
        } else {
            System.out.println("Minimum element is: " + min);
        }
    }

    public static void findMax(BinarySearchTree bst) {
        int max = bst.findMax(bst.root);

        if(max == -1) {
            System.out.println("Tree is empty");
        } else {
            System.out.println("Maximum element is: " + max);
        }
    }

    public static void findHeight(BinarySearchTree bst) {
        int height = bst.findHeight(bst.root);

        if(height == -1) {
            System.out.println("Tree is empty");
        } else {
            System.out.println("Height of tree is: " + height);
        }
    }



}
