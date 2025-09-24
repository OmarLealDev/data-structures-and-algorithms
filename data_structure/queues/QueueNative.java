package queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueueNative {
  static Scanner scanner = new Scanner(System.in);

    // ---- Estructura interna: cola nativa + capacidad fija simulada ----
    private static final int MAX_SIZE = 5;           // ajusta la capacidad que quieras
    private static final Deque<Integer> queue = new ArrayDeque<>(MAX_SIZE);

    // ---- Operaciones CRUD estilo handler ----
    public static void read() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue elements are:");
        System.out.print(" Front -> ");
        boolean first = true;
        for (int x : queue) {
            if (!first) System.out.print(" -> ");
            System.out.print(x);
            first = false;
        }
        System.out.println(" -> Rear");
    }

    public static void enqueue() {
        while (true) {
            try {
                if (isFull()) {
                    throw new IndexOutOfBoundsException("Queue is full");
                }
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                queue.addLast(newValue); // equivalente a encolar al final
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
                break;
            }
        }
    }

    public static void dequeue() {
        while (true) {
            try {
                if (queue.isEmpty()) {
                    throw new IndexOutOfBoundsException("Queue is empty");
                }
                queue.removeFirst(); // desencola del frente
                System.out.println("Element removed");
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } finally {
                break;
            }
        }
    }

    public static void front() {
        while (true) {
            try {
                if (queue.isEmpty()) {
                    throw new IndexOutOfBoundsException("Queue is empty");
                }
                System.out.println("Front element is: " + queue.peekFirst());
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } finally {
                break;
            }
        }
    }

    public static void isEmptyHandler() {
        System.out.println(queue.isEmpty() ? "Queue is empty" : "Queue is not empty");
    }

    public static void isFullHandler() {
        System.out.println(isFull() ? "Queue is full" : "Queue is not full");
    }

    private static boolean isFull() {
        return queue.size() == MAX_SIZE;
    }

    // ---- Menú y main ----
    public static void showMenu() {
        System.out.println("\n-----------------------------------");
        System.out.println("1. Print queue");
        System.out.println("2. Enqueue an element");
        System.out.println("3. Dequeue an element");
        System.out.println("4. Front element");
        System.out.println("5. Is empty?");
        System.out.println("6. Is full?");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------\n");
    }

    public static void main(String[] args) {
        final int EXIT = 0;
        int option = -1;

        do {
            System.out.println("What do you want to do?");
            showMenu();

            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> read();
                    case 2 -> enqueue();
                    case 3 -> dequeue();
                    case 4 -> front();
                    case 5 -> isEmptyHandler();
                    case 6 -> isFullHandler();
                    case 0 -> System.out.println("Bye!");
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option");
            }
        } while (option != EXIT);
    }
}
