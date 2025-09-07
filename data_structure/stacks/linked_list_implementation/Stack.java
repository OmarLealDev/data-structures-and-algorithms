package stacks.linked_list_implementation;

public class Stack {
    Node top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public void read(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        // System.out.println("top -> ");
        System.out.println("\nStack element\n");

        // while (temp != null) {
        //     System.out.println(temp.data);
        //     temp = temp.next;
        // }

        while (temp != null) {
            System.out.println("| "+ temp.data +" |");
            System.out.println("|___|");

            temp = temp.next;
        }


        // System.out.println("null");

    }

    public void top(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        System.out.println("Top element: " + top.data);

    }

    public void push(int element){
        Node newNode = new Node(element);


        if(top == null){
            top = newNode;
            size++;
            return;
        }

        Node temp = top;
        newNode.next = temp;
        top = newNode;
        size++;
    }

    public void pop(){
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        Node temp = top;
        top = temp.next;

    }

    public void reversed(){
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        java.util.Stack<Node> s = new java.util.Stack<>();

        Node temp = top;

        while (temp != null) {
            s.push(temp);
            temp = temp.next;
        }

        temp = s.peek();
        top = temp;
        s.pop();


        while (!s.isEmpty()) {
            temp.next = s.peek();
            s.pop();
            temp = temp.next;
        }

        temp.next = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
