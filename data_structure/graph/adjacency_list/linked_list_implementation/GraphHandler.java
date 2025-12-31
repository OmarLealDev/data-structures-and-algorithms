package graph.adjacency_list.linked_list_implementation;

import java.util.Scanner;

public class GraphHandler {
    
    static Scanner scanner = new Scanner(System.in);

    public static void readVertice(VertexList vertexList){
        vertexList.readVertice();
    }

    public static void readEdge(VertexList vertexList){
        vertexList.readEdge();
    }

    public static void addVertice(VertexList vertexList){
       
        while (true) {
            System.out.println("Enter the vertice name: ");
            String verticeName = scanner.nextLine();
            vertexList.addVertice(verticeName);
            break;
        }
    }

    public static void addEdge(VertexList vertexList){
        while (true) {
            try{
                System.out.println("Vertices positions: ");
                vertexList.readVertice();
                System.out.println("Enter the source vertice position: ");
                int origin = Integer.parseInt(scanner.nextLine());
                if(vertexList.isOutOfBounds(origin)){
                    System.out.println("The vertice position does not exist.");
                    continue;
                }
                System.out.println("Enter the vertice destiny position: ");
                int destiny = Integer.parseInt(scanner.nextLine());
                if(vertexList.isOutOfBounds(destiny)){
                    System.out.println("The vertice position does not exist.");
                    continue;
                }
                System.out.println("Enter the edge weight: ");
                int weight = Integer.parseInt(scanner.nextLine());
                vertexList.addEdge(origin, destiny, weight);
            break;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            
        }
    }


    public static void updateVertice(VertexList vertexList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void updateEdge(VertexList vertexList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void deleteVertice(VertexList vertexList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void deleteEdge(VertexList vertexList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    public static void findAdjacents(VertexList vertexList) {
        while(true) {
            try {
                System.out.println("Vertices positions:");
                vertexList.readVertice();
                System.out.println("\nEnter the vertice position to find adjacents vertices: ");
                int verticePosition = Integer.parseInt(scanner.nextLine());
                if(vertexList.isOutOfBounds(verticePosition)) {
                    System.err.println("\nThe vertice position doesn't exist.");
                    continue;
                }
                vertexList.findAdjacents(verticePosition);
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

        VertexList vertextList = new VertexList(2);

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("What do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> GraphHandler.readVertice(vertextList);
                    case 2 -> GraphHandler.readEdge(vertextList);
                    case 3 -> GraphHandler.addVertice(vertextList);
                    case 4 -> GraphHandler.addEdge(vertextList);
                    case 5 -> GraphHandler.updateVertice(vertextList);
                    case 6 -> GraphHandler.updateEdge(vertextList);
                    case 7 -> GraphHandler.deleteVertice(vertextList);
                    case 8 -> GraphHandler.deleteEdge(vertextList);
                    case 9 -> GraphHandler.findAdjacents(vertextList);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }
}
