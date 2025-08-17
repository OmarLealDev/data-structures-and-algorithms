package hash_tables;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetNative {
    private static final Scanner scanner = new Scanner(System.in);
    private static HashSet<String> set = new HashSet<>();

    public static void ejecutarMenu() {
        int option;

        do {
            mostrarMenu();
            option = leerOpcion();

            switch (option) {
                case 1 -> addElement();
                case 2 -> containsElement();
                case 3 -> removeElement();
                case 4 -> printElements();
                case 5 -> printSize();
                case 6 -> clearSet();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }

        } while (option != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ HashSet (API Nativa) ---");
        System.out.println("1. Agregar elemento");
        System.out.println("2. Verificar existencia");
        System.out.println("3. Eliminar elemento");
        System.out.println("4. Mostrar todos los elementos");
        System.out.println("5. Mostrar tamaño");
        System.out.println("6. Limpiar conjunto");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    public static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida. Intenta de nuevo.");
            return -1;
        }
    }

    public static void addElement() {
        System.out.print("Ingresa el elemento a agregar: ");
        String value = scanner.nextLine();
        boolean added = set.add(value);
        if (added) {
            System.out.println("Elemento agregado exitosamente.");
        } else {
            System.out.println("El elemento ya existía. No se agregó duplicado.");
        }
    }

    public static void containsElement() {
        System.out.print("Ingresa el elemento a verificar: ");
        String value = scanner.nextLine();
        if (set.contains(value)) {
            System.out.println("El conjunto contiene el elemento.");
        } else {
            System.out.println("El conjunto NO contiene el elemento.");
        }
    }

    public static void removeElement() {
        System.out.print("Ingresa el elemento a eliminar: ");
        String value = scanner.nextLine();
        boolean removed = set.remove(value);
        if (removed) {
            System.out.println("Elemento eliminado.");
        } else {
            System.out.println("El elemento no existía.");
        }
    }

    public static void printElements() {
        if (set.isEmpty()) {
            System.out.println("El conjunto está vacío.");
        } else {
            System.out.println("Elementos del conjunto:");
            for (String val : set) {
                System.out.println("- " + val);
            }
        }
    }

    public static void printSize() {
        System.out.println("Tamaño del conjunto: " + set.size());
    }

    public static void clearSet() {
        set.clear();
        System.out.println("Conjunto limpiado.");
    }

}
