package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterative {

    Node root;

    public BinarySearchTreeIterative() {
        root = null;
    }

    public Node insert(Node rootPointer, int newValue){
        Node newNode = new Node(newValue);

        if(rootPointer == null){
            return newNode;
        }

       Node curr = rootPointer, parent = null;

       while (curr != null) {
            parent = curr;
            if (newValue <= curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
       }

       if(newValue <= parent.data) parent.left = newNode; else parent.right = newNode;
       return rootPointer;

    }

    public boolean search(Node rootPointer, int data){
        Node current = rootPointer;
        while (current != null) {
            if(current.data == data) return true;
            current = (data < current.data) ? current.left : current.right; 
        }
        return false;
    }

    public int finMin(Node rootPointer){
        if(rootPointer == null){
            return -1;
        }

        Node current = rootPointer;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    public int findMax(Node rootPointer){
        if(rootPointer == null){
            return -1;
        }

        Node current = rootPointer;
        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    public Node detele(Node rootPointer, int data){
        Node curr = rootPointer, parent = null;

        // 1) Buscar el nodo y su padre
        while (curr != null && curr.data != data){
            parent = curr;
            curr = (data < curr.data) ? curr.left : curr.right;
        }
        if (curr == null) return rootPointer; // no encontrado

        // 2) Caso con 2 hijos: reemplazar por el mínimo del subárbol derecho
        if (curr.left != null && curr.right != null){
            Node succParent = curr;
            Node succ = curr.right;
            while (succ.left != null){
                succParent = succ;
                succ = succ.left;
            }
            // Copiar valor y ahora borrar el sucesor (que tendrá a lo mucho un hijo derecho)
            curr.data = succ.data;
            // Ajustar referencias para borrar succ
            curr = succ;
            parent = succParent;
        }

        Node child = (curr.left != null) ? curr.left : curr.right;
        if (parent == null){
            // borrando la raíz
            rootPointer = child;
        } else if (parent.left == curr){
            parent.left = child;
        } else {
            parent.right = child;
        }
        return rootPointer;
    }

    public int findHeight(Node rootPointer){
        if(rootPointer == null) return -1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootPointer);
        int height = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node n = queue.poll();
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            height++;
        }
        return height;
    }

    public void traversalDFPreorder(Node rootPointer){
        if(rootPointer == null){
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(rootPointer);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.println(n.data + " ");
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }
    }

    public void traversalDFInorder(Node rootPointer){
        Deque<Node> stack = new LinkedList<>();
        Node current = rootPointer;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.println(current.data + " ");
            current = current.right;
        }
    }

    public void traversalDFPostorder(Node rootPointer){
        Deque<Node> stack = new ArrayDeque<>();
        Node current = rootPointer, lastVisited = null;
        while (current != null || !stack.isEmpty()) {
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                Node peek = stack.peek();
                if(peek.right != null && lastVisited != peek.right){
                    current = peek.right;
                }else{
                    System.out.println(peek.data + " ");
                    lastVisited = stack.pop();
                }
            }
        }
    }

    public void traversalBF(Node rootPointer){
        if (rootPointer == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(rootPointer);
        while (!q.isEmpty()){
            Node n = q.poll();
            System.out.println(n.data + " ");
            if (n.left  != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }

    public boolean isBinarySearchTree(Node rootPointer){
          Deque<Node> stack = new ArrayDeque<>();
        Node curr = rootPointer;
        Integer prev = null;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && curr.data <= prev) return false;
            prev = curr.data;
            curr = curr.right;
        }
        return true;
    }

    public Node inorderSuccessor(Node rootPointer, int key){
        Node curr = rootPointer, successor = null;

        // 1) Buscar el nodo y, de paso, rastrear posible sucesor
        while (curr != null){
            if (key < curr.data){
                successor = curr;     // candidato mientras vamos a la izquierda
                curr = curr.left;
            } else if (key > curr.data){
                curr = curr.right;
            } else {
                break;
            }
        }
        if (curr == null) return null; // no existe el key

        // 2) Si tiene subárbol derecho: min del derecho
        if (curr.right != null){
            Node t = curr.right;
            while (t.left != null) t = t.left;
            return t;
        }
        // 3) Si no, el último ancestro donde giramos a la izquierda
        return successor;
    }

}
