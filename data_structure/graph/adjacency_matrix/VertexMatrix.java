package graph.adjacency_matrix;

import java.util.Queue;
import java.util.ArrayDeque;

public class VertexMatrix {

    private String[] vertexList;
    private int vertexPointer = 0;
    private int[][] edgeMatrix;

    public VertexMatrix(int verticeAmount){
        vertexList = new String[verticeAmount];
        edgeMatrix = new int[verticeAmount][verticeAmount];
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
        System.out.println("New vertice list created");
    }

    public void readVertice(){
        if(isVerticeEmpty()){
            System.err.println("There are no vertices to show.");
            return;
        }
        System.out.println("Vertices:");
        for(int i = 0; i < vertexList.length; i++){
            if(vertexList[i] != null){
                System.out.println(i + ": " + vertexList[i]);
            }
        }
    }

    public void readEdge(){
        if(isVerticeEmpty()){
            System.err.println("There are no vertices to show.");
            return;
        }

        System.out.println("Edges:");
        for (int i = 0; i < edgeMatrix.length; i++) {
            if(edgeMatrix[i] == null) {
                continue;
            }
            System.out.print(i);
            for (int j = 0; j < edgeMatrix[i].length; j++) {
                if(j == 0) {
                    System.out.print(" [");
                }
                
                System.out.print(vertexList[j] + " = " + edgeMatrix[i][j]);

                if(j != edgeMatrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

    }

    public void addVertice(String vertice){
        if(isVerticeFull()){
            System.err.println("There are no more space for vertices");
            createNewVerticeList();
        }
        vertexList[vertexPointer++] = vertice;
       System.out.println("\nVertice added.");
    }

    public void addEdge(int verticePosition1, int verticePosition2, int weight){
        edgeMatrix[verticePosition1][verticePosition2] = weight;
        System.out.println("\nEdge added.");
    }

    public void findAdjacents(int position) {

        boolean hasAdjacents = false;
        for(int i = 0; i < edgeMatrix[position].length; i++) {
            if(edgeMatrix[position][i] != 0) {
                System.out.println(i +" : "+ vertexList[position] + " -> " + vertexList[i] + " = " + edgeMatrix[position][i]);
                hasAdjacents = true;
            }
        }

        if(!hasAdjacents) {
            System.out.println("There are no adjacents.");
        }
    }

    public void bfs(int startPosition) {
        if(isVerticeEmpty()){
            System.err.println("There are no vertices to traverse.");
            return;
        }
        if(startPosition < 0 || startPosition >= vertexPointer || vertexList[startPosition] == null){
            System.err.println("The vertice position doesn't exist.");
            return;
        }

        boolean[] visited = new boolean[vertexPointer];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[startPosition] = true;
        queue.offer(startPosition);

        System.out.println("BFS Traversal starting from vertex " + startPosition + ": " + vertexList[startPosition]);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println("Visit: " + u + " -> " + vertexList[u]);

            for (int v = 0; v < vertexPointer; v++) {
                if (edgeMatrix[u][v] != 0 && !visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }

        }
    }

    public void dfs(int startPosition){
        if(isVerticeEmpty()){
            System.err.println("There are no vertices to traverse.");
            return;
        }
        if(startPosition < 0 || startPosition >= vertexPointer || vertexList[startPosition] == null){
            System.err.println("The vertice position doesn't exist.");
            return;
        }

        boolean[] visited = new boolean[vertexPointer];
        dfsRecursive(startPosition, visited);
    }

    
    private void dfsRecursive(int u, boolean[] visited){
        visited[u] = true;
        System.out.println("Visit: " + u + " -> " + vertexList[u]);

        for(int v = 0; v < vertexPointer; v++){
            if(edgeMatrix[u][v] != 0 && !visited[v]){
                dfsRecursive(v, visited);
            }
        }
    }


}
