package graph.adjacency_list.binary_search_tree_implementation;

import java.util.List;

public class BST {

    private Node root;

    public void insert(int data){
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data < root.data){
            root.left = insertRec(root.left, data);
        } else if(data > root.data){
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public boolean contains(int data){
        return containsRec(root, data);
    }

    private boolean containsRec(Node root, int data){
        if(root == null){
            return false;
        }
        if(data < root.data){
            return containsRec(root.left, data);
        } else if(data > root.data){
            return containsRec(root.right, data);
        } else {
            return true;
        }
    }

    public List<Integer> getAll(){
        List<Integer> result = new java.util.ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(Node root, List<Integer> result){
        if(root != null){
            inOrder(root.left, result);
            result.add(root.data);
            inOrder(root.right, result);
        }
    }
    
    public boolean isEmpty(){
        return root == null;
    }

}