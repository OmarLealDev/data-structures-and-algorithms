package graph.adjacency_matrix;

import java.util.Scanner;

public class GraphHandler {

    static Scanner scanner = new Scanner(System.in);

    public static void readVertice(VertexMatrix vertexMatrix){
        vertexMatrix.readVertice();
    }

    public static void readEdge(VertexMatrix vertexMatrix){
        vertexMatrix.readEdge();
    }

    public static void addVertice(VertexMatrix vertexMatrix){
        while (true) { 
            System.out.println("Enter the vertice name: ");
            String vertice = scanner.nextLine();
            vertexMatrix.addVertice(vertice);
            break;
        }
    }

    public static void addEdge(VertexMatrix vertexMatrix){
        while (true) {
            try{
                System.out.println("Vertices positions: ");
                vertexMatrix.readVertice();
                System.out.println("Enter the vertice origin position: ");
                int origin = Integer.parseInt(scanner.nextLine());
                if(vertexMatrix.isOutOfBounds(origin)){
                    System.err.println("The vertice position doesn't exist.");
                    continue;
                }
                System.out.println("Enter the vertice destiny position: ");
                int destiny = Integer.parseInt(scanner.nextLine());
                if(vertexMatrix.isOutOfBounds(destiny)){
                    System.err.println("The vertice position doesn't exist.");
                    continue;
                }
                System.out.println("\nEnter the weight of the edge: ");
                int weight = Integer.parseInt(scanner.nextLine());
                vertexMatrix.addEdge(origin, destiny, weight);
                break;
            }catch(NumberFormatException e){
                System.err.println("Please, enter a valid number.");
            }
        }
    }

    public static void updateVertice(VertexMatrix vertexMatrix) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void updateEdge(VertexMatrix vertexMatrix) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void deleteVertice(VertexMatrix vertexMatrix) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void deleteEdge(VertexMatrix vertexMatrix) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public static void findAdjacents(VertexMatrix vertexMatrix) {
        while(true) {
            try {
                System.out.println("Vertices positions:");
                vertexMatrix.readVertice();
                System.out.println("\nEnter the vertice position to find adjacents vertices: ");
                int verticePosition = Integer.parseInt(scanner.nextLine());
                if(vertexMatrix.isOutOfBounds(verticePosition)) {
                    System.err.println("\nThe vertice position doesn't exist.");
                    continue;
                }
                vertexMatrix.findAdjacents(verticePosition);
                break;
            } catch (NumberFormatException e) {
                System.err.println("\nPlease, enter a valid number.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Read vertice of graph");
        System.out.println("2. Read edge of graph");
        System.out.println("3. Insert an vertice to graph");
        System.out.println("4. Inster an edge to graph");
        System.out.println("5. Update an vertice of graph");
        System.out.println("6. Update an edge of graph");
        System.out.println("7. Delete an vertice of graph");
        System.out.println("8. Delete an edge of graph");
        System.out.println("9. Find adjacents of a vertice");
        System.out.println("-----------------------------------");
    }




 public static void main(String[] args) {

        VertexMatrix vertexMatrix = new VertexMatrix(4);

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("What do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> GraphHandler.readVertice(vertexMatrix);
                    case 2 -> GraphHandler.readEdge(vertexMatrix);
                    case 3 -> GraphHandler.addVertice(vertexMatrix);
                    case 4 -> GraphHandler.addEdge(vertexMatrix);
                    case 5 -> GraphHandler.updateVertice(vertexMatrix);
                    case 6 -> GraphHandler.updateEdge(vertexMatrix);
                    case 7 -> GraphHandler.deleteVertice(vertexMatrix);
                    case 8 -> GraphHandler.deleteEdge(vertexMatrix);
                    case 9 -> GraphHandler.findAdjacents(vertexMatrix);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }

}
