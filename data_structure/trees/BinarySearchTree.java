package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    trees.Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void read(){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Node insert(Node rootPointer, int newValue){
        if(rootPointer == null){
            rootPointer = new Node(newValue);
        }else if (newValue <= rootPointer.data) {
            rootPointer.left = insert(rootPointer, newValue);
        }else{
            rootPointer.right = insert(rootPointer, newValue);
        }

        return rootPointer;
    }

    private Node findMinNode(Node rootPointer){
        if(rootPointer == null){
            return null;
        }

        if(rootPointer.left == null){
            return rootPointer;
        }

        return findMinNode(rootPointer);
    }

    public Node delete(Node rootPointer, int data){

        if(rootPointer == null){
            return rootPointer;
        }

        if(data < rootPointer.data){
            rootPointer.left = delete(rootPointer.left, data);
        }else if(data > rootPointer.data){
            rootPointer.right = delete(rootPointer.right, data);
        }else{
               // Case 1: Leaf node
            if(rootPointer.left == null && rootPointer.right == null) {
                rootPointer = null;
            } 
            // Case 2: One child
            else if(rootPointer.left == null) {
                rootPointer = rootPointer.right;
            } else if(rootPointer.right == null) {
                rootPointer = rootPointer.left;
            }
            // Case 3: 2 Children
            else {
                Node temp = findMinNode(rootPointer.right);
                rootPointer.data = temp.data;
                rootPointer.right = delete(rootPointer.right, temp.data);
            }
        }


        return rootPointer;
    }

    public boolean search(Node rootPointer, int data){
        if(rootPointer == null){
            return false;
        }

        if(rootPointer.data == data){
            return true;
        } else if(data < rootPointer.data){
            return search(rootPointer.left, data);
        }else{
            return search(rootPointer.right, data);
        }
    }

    public int findMin(Node rootPointer){
        if (rootPointer == null) {
            return -1;
        }

        if(rootPointer.left == null){
            return rootPointer.data;
        }

        return findMin(rootPointer.left);
    }

    public int findMax(Node rootPointer){
        if (rootPointer == null) {
            return -1;
        }

        if(rootPointer.right == null){
            return rootPointer.data;
        }

        return findMax(rootPointer.right);
    }

    public int findHeight(Node rootPointer){
        if(rootPointer == null){
            return -1;
        }

        int leftHeight = findHeight(rootPointer.left);
        int rightHeight = findHeight(rootPointer.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void traversalDFPreorder(Node rootPointer){
        if(rootPointer == null){
            return;
        }

        System.out.println(rootPointer.data + " ");
        traversalDFPreorder(rootPointer.left);
        traversalDFPreorder(rootPointer.right);
    }

    public void traversalDFInorder(Node rootPointer){
        if(rootPointer == null){
            return;
        }

        traversalDFInorder(rootPointer.left);
        System.out.println(rootPointer.data+ "");
        traversalDFInorder(rootPointer.right);
    }

    public void traversalDFPostorder(Node rootPointer){
        if(rootPointer == null){
            return;
        }

        traversalDFPostorder(rootPointer.left);
        traversalDFPostorder(rootPointer.right);
        System.out.println(rootPointer.data + " ");
    }

    public void traversalBF(Node rootPointer){
        if(rootPointer == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(rootPointer);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.println(current.data + " ");

            if(current.left != null){
                queue.add(current.left);
            }
                       
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private boolean isBSTUtil(Node rootPointer, int minValue, int maxValue){
        if (rootPointer == null) {
            return true;
        }

        return rootPointer.data > minValue && rootPointer.data < maxValue
                && isBSTUtil(rootPointer.left, minValue, rootPointer.data)
                && isBSTUtil(rootPointer.right, rootPointer.data, maxValue);
    }

    public boolean isBinarySearchTree(Node rootPointer){
        return isBSTUtil(rootPointer, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Node find(Node rootPointer, int data){
         if(rootPointer == null) {
            return null;
        }

        if(rootPointer.data == data) {
            return rootPointer;
        } else if(data < rootPointer.data) {
            return find(rootPointer.left, data);
        } else {
            return find(rootPointer.right, data);
        }
    }

    public Node inorderSuccessor(Node rootPointer, int data){
        Node current = find(rootPointer, data);

        if(current == null) {
            return null;
        }

        // Case 1: treess.Node has right subtree
        if(current.right != null) {
            return findMinNode(current.right);
        } 
        
        // Case 2: No right subtree
        Node successor = null;
        Node ancestor = rootPointer;

        while(ancestor != current) {
            if(current.data <= ancestor.data) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }

        return successor;
    }



}
