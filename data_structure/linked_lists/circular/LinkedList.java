package linked_lists.circular;

public class LinkedList {
    Node head;
    Node tail;
    int size;

    public boolean isEmpty (){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(int value){
        Node newNode = new Node(value);
        if(head ==null){
            head = tail = newNode;
            newNode.next = newNode;
        }else{
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addElementAtNPosition(int value, int position){
        if (position < 0 || position > size) throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0 ");

        if(head == null || position == 0){
            addFirst(value);
            return;
        }

        if (position == size) {
            addElementAtEnd(value);
            return;
        }

        Node prev = head;
        for(int i = 0; i < position - 1; i++){
            prev = prev.next;
        }

        Node newNode = new Node(value);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public void addElementAtEnd(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = tail = newNode;
            newNode.next = newNode;
        }else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public void read(){
        if(isEmpty()){System.out.println("[]"); return;}
        Node current = head;

        for(int i = 0; i < size; i++){
            System.out.print(current.data);
            if (i < size-1) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
    }
    
    public void readRecursive(Node headPointer){
        if(size == 0) {
            System.out.println("[]");
            return;
        }

        if(headPointer == null){
            headPointer = head;
        }

        System.out.print("[ ");
        readRecursiveHelper(headPointer, size);
        System.out.print(" ] (circular)");

    }
    
    private void readRecursiveHelper(Node current, int remaining){
        if(remaining == 0) return;
        System.out.println(current.data);
        if(remaining > 1) System.out.println(" -> ");
        readRecursiveHelper(current.next, remaining - 1);
    }

    public void updateAnElement(int value, int position){
        checkElementIndex(position);
        nodeAt(position).data = value;
    }

    public void deteleAnElemente(int position){
        checkElementIndex(position);

        if(position == 0){
            if(size==1){
                head = tail = null;
                size = 0;
                return;
            }

            head = head.next;
            tail.next = head;
            size--;
            return;
        }

        Node prev = head;
        for(int i = 0; i < position -1;i++) prev = prev.next;

        Node target = prev.next;

        if(target == tail){
            prev.next = head;
            tail = prev;
        }else{
            prev.next = target.next;
        }
        size--;
    }

    public void reversed(){
        if(size <= 1)return;
        Node oldHead = head;
        Node prev = tail;
        Node current = head;

        do{
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }while(current != head);

        head = tail;
        tail = oldHead;
        tail.next = head;
    }

    public void reversedRecursive(Node headPointer){
        if(size <= 1) return;
        if(headPointer == null) headPointer = head;

        Node oldHead = head;
        reversedRecursiveHelper(headPointer, tail, oldHead);

        head = tail;
        tail = oldHead;
        tail.next = head;
    }

    private void reversedRecursiveHelper(Node current, Node prev, Node stop){
        Node next = current.next;
        current.next = prev;

        if(next == stop) return;

        reversedRecursiveHelper(next, current, stop);
    }


    private void checkElementIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    
    private Node nodeAt(int index){
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }


}
