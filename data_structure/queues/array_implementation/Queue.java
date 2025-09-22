package queues.array_implementation;

public class Queue {
    private final int maxSize;
    private final int[] queue;
    private int front;
    private int rear;

    public Queue(int maxSize){
        if(maxSize <= 0) throw new IllegalArgumentException("MaxSize must be great that 0");
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public void read(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue elements are:");

        System.out.print(" Front -> ");

        for(int i = front; i != rear; i = (i + 1) % maxSize){
            System.out.print(queue[i] + " -> ");
        }

        System.out.print(queue[rear]);
        System.out.print(" <- Rear");
    }

    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public void enqueue(int element){
        if(isFull()){
            throw new IndexOutOfBoundsException("Queue is full");
        }

        if(isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear =  (rear + 1) % maxSize;
        }
        queue[rear] = element;
    }

    public void dequeue(){
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        if(front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
    }

    public void front(){
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        System.out.println("Front element is: " + queue[front]);
    }
}
