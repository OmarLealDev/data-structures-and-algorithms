package graph.adjacency_list.linked_list_implementation;

public class LinkedList {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(int data, int weight){
        Node newNode = new Node(data, weight);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void print(){
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + ", " + current.weight + "] -> ");
            current = current.next;
        }
        System.out.println("null"); 
    }

}
