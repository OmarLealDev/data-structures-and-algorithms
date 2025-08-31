package linked_lists.circular_doubly;

public class LinkedListDoublyCircular {
    Node head;
    Node tail;
    int size;


    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }else{
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode; 
        }
        size++;

    }

    public void addElementAtNPosition(int value, int position){
        if (position < 0 || position > size) throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0");

        if(head == null || position == 0){
            addFirst(value);
            return;
        }

        if(position == size){
            addElementAtEnd(value);
            return;
        }


        Node prev;

        if(position <=  (size >> 1)){
            prev = head;
            for(int i = 0; i < position -1; i++)
                prev = prev.next;
        }else{
            int backSteps = size - position;
            prev = tail;
            for(int i = 0; i < backSteps; i++)
                prev = prev.prev;
        }

        Node next = prev.next;
        Node newNode = new Node(value);

        newNode.prev = prev;
        newNode.next = next;
        prev.next = newNode;
        next.prev = newNode;

        size++;
    }

    public void addElementAtEnd(int value){

        Node newNode = new Node(value);

        if(head == null){
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }

        size++;
    }

    

    public void read(){
        if(isEmpty()){
            System.out.println("[]");
            return;
        }

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
        if(size == 0){
            System.out.println("[]");
            return;
        }

        if(head == null ){
            headPointer = head;
        }

        System.out.print("[");
        readRecursiveHelper(headPointer, size);
        System.out.print("]");
    }

    private void readRecursiveHelper(Node current, int size){
        if(size == 0) return;
        System.out.println(current.data);
        if(size > 1) System.out.println(" -> ");
        readRecursiveHelper(current.next, size - 1);
    }

    public void updateAnElement(int value, int position){
        checkElementIndex(position);
        nodeAt(position).data = value;
    }

    public void deleteAnElement(int position){
        if (position < 0 || position >= size) throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0");

        if(size == 0){
            throw new IllegalStateException("Empty list");
        }

        if(position == 0){
            if(size == 1){
                head = tail = null;
                size = 0;
                return;
            }

            head = head.next;
            head.prev = tail;
            tail.next = head;
            size--;
            return;

        }

        Node prev = head;
        for(int i = 0; i < position -1; i++) prev = prev.next;

        Node target = prev.next;

        if(target == tail){
            prev.next = head;
            tail = prev;
            head.prev = tail;
        }else{
            prev.next = target.next;
            target.next.prev = prev;
        }

        size--;
    }
    
    private void checkElementIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node nodeAt(int index){
        Node current = head;
        for(int i = 0; i< index; i++){
            current = current.next;
        }
        return current;
    }

    public void reversed(){
         if(size <= 1)return;
        Node oldHead = head;
        Node current = head;

        do{
            Node next = current.next;
            current.next = current.prev;
            current.prev = next;
            current = next;
        }while(current != head);

        head = tail;
        tail = oldHead;
    }


    public void reversedRecursive() {
        if (size <= 1) return;
        Node stop = head;                
        reverseRec(head, stop);          
        Node oldHead = stop;
        head = tail;                      
        tail = oldHead;                   
    }

    private void reverseRec(Node current, Node stop) {
        Node next = current.next;         
        Node tmp = current.next;
        current.next = current.prev;
        current.prev = tmp;

        if (next == stop) return;         
        reverseRec(next, stop);
    }

}
