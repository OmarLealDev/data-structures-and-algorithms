package data_structure.hash_tables;

import java.util.LinkedList;

public class HashTable <K,V>{
    private class Node{
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 0;
    private LinkedList<Node>[] table;


    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        for(Node node : table[index]) {
            if(node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        table[index].add(new Node(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        for(Node node : table[index]) {
            if(node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        for(Node node : table[index]) {
            if(node.key.equals(key)) {
                table[index].remove(node);
                System.out.println("Element removed");
                return;
            }
        }
        System.out.println("The element doesn't exist");
    }

    public void print() {
        for(int i = 0; i < capacity; i++) {
            System.out.print("Index " + i + ": ");
            for(Node node : table[i]) {
                System.out.print("[" + node.key + ": " + node.value + "] ");
            }
            System.out.println();
        }
    }
}
