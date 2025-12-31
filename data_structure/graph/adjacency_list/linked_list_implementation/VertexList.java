package graph.adjacency_list.linked_list_implementation;

public class VertexList {
    private String[] verticeList;
    private int verticePointer;
    private LinkedList[] edgeList;

    public VertexList(int size) {
        this.verticeList = new String[size];
        this.edgeList = new LinkedList[size];
    }

    public boolean isOutOfBounds(int position){
        return position < 0 || position > verticePointer;
    }

    public boolean isVerticeEmpty(){
        return verticePointer == 0;
    }

    public boolean isVerticeFull(){
        return verticePointer == verticeList.length;
    }

    private void createNewVerticeList(){
        System.out.println("Creating a new vertice list....");
        String[] newVertexList = new String[verticeList.length * 2];
        System.out.println("Copying elements...");
        System.arraycopy(verticeList, 0, newVertexList, 0, verticeList.length);
        verticeList = newVertexList;
        System.out.println("New vertice list created.");
    }

    private void createNewEdgeList(){
        System.out.println("Creating a new edge list....");
        LinkedList[] newEdgeList = new LinkedList[edgeList.length * 2];
        System.out.println("Copying elements...");
        System.arraycopy(edgeList, 0, newEdgeList, 0, edgeList.length);
        edgeList = newEdgeList;
        System.out.println("New edge list created.");
    }

    public void readVertice(){
        if(isVerticeEmpty()){
            System.out.println("The vertice list is empty.");
            return;
        }
        System.out.println("Vertices: ");
        for(int i = 0; i < verticePointer; i++){
            System.out.println("Position " + i + ": " + verticeList[i]);
        }
        System.out.println();
    }

    public void readEdge(){
        if(isVerticeEmpty()){
            System.out.println("The vertice list is empty.");
            return;
        }
        int counter = 0;
        for(LinkedList edges : edgeList){
            if(edges != null){
                counter++;
                continue;
            }
            System.out.print("Edges of vertice " + verticeList[counter] + ": ");
            edges.print();
            counter++;
        }
        System.out.println();
    }

    public void addVertice(String vertice){
        if(isVerticeFull()) {
            System.out.println("The vertice list is full.");
            createNewVerticeList();
            createNewEdgeList();
        }
        verticeList[verticePointer] = vertice;
        edgeList[verticePointer] = new LinkedList();
        verticePointer++;
    }

    public void addEdge(int verticePosition1, int verticePosition2, int weight) {
        LinkedList edge = edgeList[verticePosition1];
        edge.add(verticePosition2, weight);
    }

    public void findAdjacents(int position) {
        LinkedList edge = edgeList[position];
        edge.print();
    }

    

}
