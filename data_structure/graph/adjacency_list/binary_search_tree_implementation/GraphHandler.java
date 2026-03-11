package graph.adjacency_list.binary_search_tree_implementation;

import java.util.List;
import java.util.Scanner;

public class GraphHandler {

    private String[] vertexList;
    private int vertexPointer = 0;
    private BST[] adjacencyList;

    static Scanner scanner = new Scanner(System.in);

    public GraphHandler(int initialSize){
        vertexList = new String[initialSize];
        adjacencyList = new BST[initialSize];
    }

    public boolean isOutOfBounds(int position){
        return position < 0 || position >= vertexList.length;
    }
    
    public boolean isVerticeEmpty(){
        return vertexPointer == 0;
    }
    public boolean isVerticeFull(){
        return vertexPointer == vertexList.length;
    }
    public void createNewVerticeList(){
        System.out.println("Creating new vertex list...");
        String[] newVertexList = new String[vertexList.length * 2];
        System.out.println("Copying elements....");
        System.arraycopy(vertexList, 0, newVertexList, 0, vertexList.length);
        vertexList = newVertexList;

        BST[] newAdjacencyList = new BST[adjacencyList.length * 2];
        System.out.println("Copying adjacency list....");
        System.arraycopy(adjacencyList, 0, newAdjacencyList, 0, adjacencyList.length);
        adjacencyList = newAdjacencyList;

        System.out.println("New vertice list created");
    }

    public void addVertice(String verticeName){
        if(isVerticeFull()){
            createNewVerticeList();
        }
        vertexList[vertexPointer] = verticeName;
        adjacencyList[vertexPointer] = new BST();
        vertexPointer++;
    }

    public void addEdge(int origin, int destiny){
        if(isOutOfBounds(origin) || isOutOfBounds(destiny)){
            System.err.println("One of the vertices is out of bounds.");
            return;
        }
        adjacencyList[origin].insert(destiny);
        System.out.println("Edge added from " + vertexList[origin] + " to " + vertexList[destiny]);
    }

    public void readVertices(){
        if(vertexPointer == 0){
            System.err.println("There are no vertices to show.");
            return;
        }
        System.out.println("Vertices:");
        for(int i = 0; i < vertexPointer; i++){
            System.out.println(i + ": " + vertexList[i]);
        }

    }

    public void readAdjacents(int position){

        if(isOutOfBounds(position)){
            System.err.println("The vertex is out of bounds.");
            return;
        }

        BST neighbors = adjacencyList[position];
        if (neighbors == null || neighbors.isEmpty()) {
            System.out.println("Vertex " + vertexList[position] + " has no adjacent vertices.");
            return;
            
        }

        List<Integer> adjacentIndices = neighbors.getAll();
        System.out.println("Adjacent vertices to " + vertexList[position] + ":");
        for (int index : adjacentIndices) {
            System.out.println("- " + vertexList[index]);
        }

    }

    public void bfs(int startPosition){
        if(isOutOfBounds(startPosition)){
            System.err.println("The start vertex is out of bounds.");
            return;
        }

        boolean[] visited = new boolean[vertexPointer];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();

        visited[startPosition] = true;
        queue.add(startPosition);

        System.out.println("BFS starting from vertex: " + vertexList[startPosition]);

        while(!queue.isEmpty()){
            int currentPosition = queue.poll();
            System.out.println("Visited: " + vertexList[currentPosition]);

            BST neighbors = adjacencyList[currentPosition];
            if(neighbors == null || neighbors.isEmpty()){
                continue;
            }

            List<Integer> adjacentIndices = neighbors.getAll();
            for(int index : adjacentIndices){
                if(!visited[index]){
                    visited[index] = true;
                    queue.add(index);
                }
            }
        }
    }
    public void dfs(int startPosition){
        if(isOutOfBounds(startPosition)){
            System.err.println("The start vertex is out of bounds.");
            return;
        }

        boolean[] visited = new boolean[vertexPointer];
        System.out.println("DFS starting from vertex: " + vertexList[startPosition]);
        dfsRecursive(startPosition, visited);
    }


    private void dfsRecursive(int currentPosition, boolean[] visited){
        visited[currentPosition] = true;
        System.out.println("Visited: " + vertexList[currentPosition]);

        BST neighbors = adjacencyList[currentPosition];
        if(neighbors == null || neighbors.isEmpty()){
            return;
        }


        for(int index : neighbors.getAll()){
            if(!visited[index]){
                dfsRecursive(index, visited);
            }
        }
    }

    public static void showMenu(){
        System.out.println("\nGraph Menu:");
        System.out.println("1. Add Vertex");
        System.out.println("2. Add Edge");
        System.out.println("3. Show Vertices");
        System.out.println("4. Show Adjacents of a Vertex");
        System.out.println("5. BFS Traversal");
        System.out.println("6. DFS Traversal");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        GraphHandler graph = new GraphHandler(5);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex name: ");
                    String vertexName = scanner.nextLine();
                    graph.addVertice(vertexName);
                    break;
                case 2:
                    System.out.print("Enter origin vertex index: ");
                    int origin = scanner.nextInt();
                    System.out.print("Enter destiny vertex index: ");
                    int destiny = scanner.nextInt();
                    graph.addEdge(origin, destiny);
                    break;
                case 3:
                    graph.readVertices();
                    break;
                case 4:
                    System.out.print("Enter vertex index to show adjacents: ");
                    int position = scanner.nextInt();
                    graph.readAdjacents(position);
                    break;
                case 5:
                    System.out.print("Enter starting vertex index for BFS: ");
                    int bfsStart = scanner.nextInt();
                    graph.bfs(bfsStart);
                    break;
                case 6:
                    System.out.print("Enter starting vertex index for DFS: ");
                    int dfsStart = scanner.nextInt();
                    graph.dfs(dfsStart);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }

}
