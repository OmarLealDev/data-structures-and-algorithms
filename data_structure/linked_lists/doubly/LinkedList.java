package linked_lists.doubly;

import linked_lists.LinkedListEmptyException;

public class LinkedList {

    Node head;
    int size;

    public LinkedList(){
        head = null;
    }


    public void read() {

        if(head == null) {
            System.out.println("The linked list is empty");
            return;
        }

        Node temp = head;

        System.out.print("null <- ");

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
    
    public void readRecursive(Node headPointer) {
        if(headPointer == null) {
            System.out.println("null");
            return;
        }

        System.out.print(headPointer.data + " -> ");
        readRecursive(headPointer.next);
    }
    
    public void addFirst(int newValue){
        Node newNode = new Node(newValue);

        if(head == null){
            head = newNode;
            size++;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addElementAtNPosition(int newValue, int position){
        if(position < 0) throw new IndexOutOfBoundsException("The position must be greater than or equal to 0");

        if(head == null || position < 0){
            addFirst(newValue);
            return;
        }

        Node newNode = new Node(newValue);

        Node temp = head;
        int counter = 0;
        while(counter < position - 1 && temp != null) {
            temp = temp.next;
            counter++;
        }

        if(temp == null) {
            throw new IndexOutOfBoundsException("The position is out of bounds");
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
    }
    
    public void addElementAtEnd(int newValue) {
        if(head == null) {
            addFirst(newValue);
            return;
        }

        Node newNode = new Node(newValue);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void updateAnElement(int newValue, int position){
        if(head == null) {
            throw new LinkedListEmptyException("The linked list is empty, nothing to update");
        }

        Node temp = head;
        int counter = 0;

        while(counter < position && temp.next != null) {
            temp = temp.next;
            counter++;
        }

        if(temp == null) {
            throw new IndexOutOfBoundsException("The position is out of bounds");
        }

        temp.data = newValue;
    }


    public void deleteAnElement(int position){
        if(head == null) {
            throw new LinkedListEmptyException("The linked list is empty, nothing to remove");
        }

        if(position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        int counter = 0;
        while(counter < position - 1 && temp.next != null) {
            temp = temp.next;
            counter++;
        }

        if(temp.next == null) {
            throw new IndexOutOfBoundsException("The position is out of bounds");
        }

        Node temp2 = temp.next;
        temp.next = temp2.next;
    }

    public void reversed() {
        if(head == null) {
            throw new LinkedListEmptyException("The linked list is empty, nothing to reverse");
        }

        Node previous = null;
        Node current = head;

        while(current != null) {
            Node next = current.next;
            current.next = previous;
            current.prev = next;
            previous = current;
            current = next;
        }

        head = previous;

    }

     public void reversedRecursive(Node headPointer) {
        if(headPointer == null) {
            throw new LinkedListEmptyException("The linked list is empty, nothing to reverse");
        }

        if(headPointer.next == null) {
            head = headPointer;
            return;
        }

        reversedRecursive(headPointer.next);
        Node newNode = headPointer.next;
        newNode.next = headPointer;
        headPointer.prev = newNode;
        headPointer.next = null;
    }

}
