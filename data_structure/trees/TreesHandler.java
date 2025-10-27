package trees;

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
                break;

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
                break;

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

    public static void depthFirst(BinarySearchTree bst){
        while (true) {
            try{
                System.out.println("\nSelect the type of traversal");
                System.out.println("1. Preorder");
                System.out.println("2. Inorder");
                System.out.println("3. Postorder");
                int option = Integer.parseInt(scanner.nextLine());
                if(option < 0 || option > 3) {
                    System.err.println("Type a valid option");
                    continue;
                }
                switch (option) {
                    case 1:
                        System.out.println("Preorder traversal");
                        bst.traversalDFPreorder(bst.root);
                    break;
                    case 2:
                        System.out.println("Inorder traversal");
                        bst.traversalDFInorder(bst.root);
                    break;
                    case 3:
                        System.out.println("Postorder traversal");
                        bst.traversalDFPostorder(bst.root);
                    break;
                }
                break;
            }catch(NumberFormatException e){
                System.err.println("Type an integer");
            }
        }
    }

    public static void breadthFirts(BinarySearchTree bst) {
        System.out.println("\nBreadth First traversal");
        bst.traversalBF(bst.root);
    }

    public static void isBinarySearch(BinarySearchTree bst) {
        boolean isBST = bst.isBinarySearchTree(bst.root);

        if(isBST) {
            System.out.println("Tree is a binary search tree");
        } else {
            System.out.println("Tree is not a binary search tree");
        }
    }


    public static void inorderSuccessor(BinarySearchTree bst) {
        while (true) {
            try {
                System.out.println("Insert the element to search its inorder successor");
                int data = Integer.parseInt(scanner.nextLine());
                Node successor = bst.inorderSuccessor(bst.root, data);
                if(successor == null) {
                    System.out.println("Element doesn't exist or doesn't have successor");
                } else {
                    System.out.println("Inorder successor is: " + successor.data);
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }
        }
    }
    public static void showMenu() {
        System.out.println("\n-----------------------------------");
        System.out.println("1. Read tree");
        System.out.println("2. Insert an element of tree");
        System.out.println("3. Delete an element of tree");
        System.out.println("4. Search an element of tree");
        System.out.println("5. Find the minimum element of tree");
        System.out.println("6. Find the maximum element of tree");
        System.out.println("7. Find height of tree");
        System.out.println("8. Traversal Depth First");
        System.out.println("9. Traversal Breadth First");
        System.out.println("10. Is binary search tree?");
        System.out.println("11. Inorder successor");
        System.out.println("-----------------------------------\n");
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("\nWhat do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    // case 1 -> TreesHandler.read(bst);
                    case 2 -> TreesHandler.insert(bst);
                    case 3 -> TreesHandler.delete(bst);
                    case 4 -> TreesHandler.search(bst);
                    case 5 -> TreesHandler.findMin(bst);
                    case 6 -> TreesHandler.findMax(bst);
                    case 7 -> TreesHandler.findHeight(bst);
                    case 8 -> TreesHandler.depthFirst(bst);
                    case 9 -> TreesHandler.breadthFirts(bst);
                    case 10 -> TreesHandler.isBinarySearch(bst);
                    case 11 -> TreesHandler.inorderSuccessor(bst);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();
    }


}
