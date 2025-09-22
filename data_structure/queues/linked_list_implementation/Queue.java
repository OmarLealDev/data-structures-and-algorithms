package queues.linked_list_implementation;

public class Queue {
    Node front;
    Node rear;

    public Queue(){
        this.front = null;
        this.rear = null;
    }

    public void read(){
        if(front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        System.out.print(" Front -> ");
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(" Rear");
    }

    public boolean isEmpty(){
        return front == null && rear == null;
    }

    public void enqueue(int element){
        Node newNode = new Node(element);

        if(front == null && rear == null){
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void dequeue(){
        if(front == null){
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        if(front == rear){
            front = rear = null;
        }else{
            front = front.next;
        }

    }

    public void front(){
        if(front == null){
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        System.out.println("Front element: " + front.data);
    }
}
