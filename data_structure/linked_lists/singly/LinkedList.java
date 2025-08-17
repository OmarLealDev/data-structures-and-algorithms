package linked_lists.singly;
import linked_lists.LinkedListEmptyException;
public class LinkedList {
    Node head;
    private int size;


    public LinkedList(){
        head = null;
        size = 0;
    }


    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public void addFirst(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;

    }


    public void addElementAtNPosition(int value, int position){
        if (position < 0) throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0");

        if(head == null || position == 0){
            addFirst(value);
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;

        for(int i = 0; i < position && temp.next != null; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public Node addElementAtEnd(int value){

        if(head == null){
            addFirst(value);
        }

        Node newNode = new Node(value);
        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return newNode;
    }

    public Node addElementAtEndAndReturnNode(int data) {

        if(head == null) {
            addFirst(data);
        }

        Node newNode = new Node(data);
        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return newNode;

    }

    public void read(){
        if (head == null){
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void readRecursive(Node headPointer){
        if(headPointer == null){
            System.out.println("null");
            return;
        }

        System.out.print(headPointer.data +" -> ");
        readRecursive(headPointer.next);
    }
    
     public void updateAnElement(int data, int position) {
        if(position < 0) throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0");

        if(head == null) throw new LinkedListEmptyException("Empty linked list, nothing to update");

        Node temp = head;

        int counter = 0;
        while(counter < position) {
            temp = temp.next;
            counter++;
            if(temp == null){
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
        }


        temp.data = data;
    }

    public void deleteAnElement(int position) {
        if(position < 0) throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0");

        if(head == null) throw new LinkedListEmptyException("Empty linked list, nothing to delete");

        if(position == 0) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;

        int counter = 0;
        
        while(counter < position - 1 && temp.next != null) {
            temp = temp.next;
            counter++;
        }

        if(temp.next == null) {
            throw new IndexOutOfBoundsException("Position out of bounds, position not found");
        }

        Node temp2 = temp.next;
        temp.next = temp2.next;
        size--;
    }

    public void reversed() {
        if(head == null) {
            System.out.println("Linked list is empty, nothing to reverse");
            return;
        }

        Node prev = null;
        Node current = head;

        while(current !=  null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

    }

    public void reversedRecursive(Node headPointer) {
        if(headPointer == null) {
            throw new LinkedListEmptyException("Empty linked list, nothing to delete");
        }

        if(headPointer.next == null) {
            head = headPointer;
            return;
        }

        reversedRecursive(headPointer.next);
        Node nextNode = headPointer.next;
        nextNode.next = headPointer;
        headPointer.next = null;

    }



}
