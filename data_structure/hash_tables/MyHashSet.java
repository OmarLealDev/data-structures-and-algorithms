package hash_tables;

public class MyHashSet<E> {
    private static class Node<E> {
    
        E key;
        Node next;

        Node(E key){
            this.key = key;
        }
    }

    private Node[] table;
    private int capacity;
    private int size;
    private final float loadFactor = 0.75f;

    public MyHashSet(int capacity) {
        this.capacity = capacity;
        Node<E>[] temp = (Node<E>[]) new Node[capacity];
        this.table = temp;
        size = 0;
    }

    private int hash(E key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void add(E key) {
        if (contains(key)) return;

        int index = hash(key);
        Node newNode = new Node(key);
        newNode.next = table[index];
        table[index] = newNode;
        size++;

        if ((float) size / capacity >= loadFactor) {
            resize();
        }
    }

    public boolean contains(E key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(E key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print(current.key + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Node[] newTable = new Node[newCapacity];

        for (int i = 0; i < capacity; i++) {
            Node current = table[i];
            while (current != null) {
                Node next = current.next;
                int newIndex = Math.abs(current.key.hashCode()) % newCapacity;
                current.next = newTable[newIndex];
                newTable[newIndex] = current;
                current = next;
            }
        }

        capacity = newCapacity;
        table = newTable;
    }

}
