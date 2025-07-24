import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHandler {
    private static ArrayList<Integer> numeros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    private static void crearNumero() {
        System.out.print("Ingresa el número: ");
        int numero = scanner.nextInt();
        numeros.add(numero);
        System.out.println("Número agregado.");
    }

    private static void verNumeros() {
        if (numeros.isEmpty()) {
            System.out.println("No hay números almacenados.");
            return;
        }
        System.out.println("Contenido del ArrayList:");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println("[" + i + "] = " + numeros.get(i));
        }
    }

    private static void actualizarNumero() {
        System.out.print("Índice a actualizar: ");
        int indice = scanner.nextInt();

        if (indice < 0 || indice >= numeros.size()) {
            System.out.println("Índice fuera de rango.");
            return;
        }

        System.out.print("Nuevo valor: ");
        int nuevo = scanner.nextInt();
        numeros.set(indice, nuevo);
        System.out.println("Número actualizado.");
    }

    private static void eliminarNumero() {
        System.out.print("Índice a eliminar: ");
        int indice = scanner.nextInt();

        if (indice < 0 || indice >= numeros.size()) {
            System.out.println("Índice fuera de rango.");
            return;
        }

        numeros.remove(indice);
        System.out.println("Número eliminado.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENÚ CRUD con ArrayList ---");
            System.out.println("1. Agregar número");
            System.out.println("2. Ver números");
            System.out.println("3. Actualizar número");
            System.out.println("4. Eliminar número");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> crearNumero();
                case 2 -> verNumeros();
                case 3 -> actualizarNumero();
                case 4 -> eliminarNumero();
                case 5 -> System.exit(0);
                default -> System.out.println("Opción no válida.");
            }
        }
    }

}
