package graph.edge_list;
import java.util.LinkedList;
import java.util.Queue;

public class VertexList {
    private String[] vertexList;
    private int vertexPointer = 0;
    private Edge[] edgeList;
    private int edgePointer = 0;

    public VertexList(int vertices){
        vertexList = new String[vertices];
        edgeList = new Edge[vertices];
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

    public boolean isEdgeEmpty(){
        return edgePointer == 0;
    }

    public boolean isEdgeFull(){
        return edgePointer == edgeList.length;
    }

    public void createNewVerticeList(){
        System.out.println("Creating new vertex list...");
        String[] newVertexList = new String[vertexList.length * 2];
        System.out.println("Copying elements....");
        System.arraycopy(vertexList, 0, newVertexList, 0, vertexList.length);
        vertexList = newVertexList;
        System.out.println("New vertice list created");
    }

    public void createNewEdgeList(){
        System.out.println("Creating new edge list...");
        Edge[] newEdgeList = new Edge[edgeList.length * 2];
        System.out.println("Copying elements....");
        System.arraycopy(edgeList, 0, newEdgeList, 0, edgeList.length);
        edgeList = newEdgeList;
        System.out.println("New edge list created");
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
        if(isEdgeEmpty()){
            System.err.println("There are no edges to show.");
            return;
        }

        System.out.println("Edges:");
        for (int i = 0; i < edgeList.length; i++) {
            if(edgeList[i] != null) {
                System.out.println(i + ": " + "Start Vertex: " + edgeList[i].startVertex + ", End Vertex: " + edgeList[i].endVertex + ", Weight: " + edgeList[i].weight);
            }
        }
    }

    public void addVertice(String vertice) {
        if (isVerticeFull()) {
            System.out.println("The graph is full.");
            createNewVerticeList();
        }

        vertexList[vertexPointer] = vertice;
        vertexPointer++;
        System.out.println("Vertice added.");
    }
    public void addEdge(int origin, int destiny, int weight) {
        if(isEdgeFull()) {
            System.out.println("The edge list is full.");
            createNewEdgeList();
        }

        Edge newEdge = new Edge(origin, destiny, weight);

        edgeList[edgePointer] = newEdge;
        edgePointer++;
        System.out.println("Edge added.");
    }

    public void findAdjacents(int position) {
        if(isEdgeEmpty()) {
            System.out.println("The edge list is empty, there is no connections.");
            return;
        }

        boolean hasAdjacents = false;
        for(int i = 0; i < edgeList.length; i++) {
            if(edgeList[i] != null && edgeList[i].startVertex == position) {
                System.out.println(vertexList[edgeList[i].endVertex]);
                hasAdjacents = true;
            }
        }

        if(!hasAdjacents) {
            System.out.println("There is no adjacents.");
        }
    }

    public void bfs(int startPosition){

        if(isVerticeEmpty()){
            System.out.println("The vertice list is empty.");
            return;
        }

        if(isOutOfBounds(startPosition) || vertexList[startPosition] == null){
            System.out.println("The start position is out of bounds or does not exist.");
            return;
        }

        boolean[] visited = new boolean[vertexList.length];
        Queue<Integer> queue = new LinkedList<>();


        visited[startPosition] = true;
        queue.offer(startPosition);

        System.out.println("BFS Traversal starting from vertex "+ startPosition + ": " +vertexList[startPosition] );

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println("Visit: " + vertexList[u]);

            for (int i = 0; i < edgePointer; i++) {
            Edge e = edgeList[i];
            if (e != null && e.startVertex == u) {
                int v = e.endVertex;
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        }
    }

    public void dfs(int startPosition){
        if(isVerticeEmpty()){
            System.out.println("The vertice list is empty.");
            return;
        }

        if(isOutOfBounds(startPosition) || vertexList[startPosition] == null){
            System.out.println("The start position is out of bounds or does not exist.");
            return;
        }

        boolean[] visited = new boolean[vertexList.length];

        System.out.println("DFS traversal starting from vertex " 
                        + startPosition + ": " + vertexList[startPosition]);
        dfsRecursive(startPosition, visited);
    }

        
    private void dfsRecursive(int u, boolean[] visited) {
        visited[u] = true;
        System.out.println("Visit: " + u + " -> " + vertexList[u]);

        for (int i = 0; i < edgePointer; i++) {
            Edge e = edgeList[i];
            if (e != null && e.startVertex == u) {
                int v = e.endVertex;
                if (!visited[v]) {
                    dfsRecursive(v, visited);
                }
            }
        }
    }


}
