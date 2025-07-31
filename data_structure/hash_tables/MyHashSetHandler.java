package data_structure.hash_tables;

import java.util.Scanner;

public class MyHashSetHandler {
    static Scanner scanner = new Scanner(System.in);
    private static MyHashSet<String> set = new MyHashSet<>(10); 

    public static void ejecutarMenu(){
        int option;

        do {
            mostrarMenu();
            option = leerOpcion();

            switch (option) {
                case 1 -> agregarElemento();
                case 2 -> verificarElemento();
                case 3 -> eliminarElemento();
                case 4 -> imprimirElementos();
                case 5 -> imprimirTamaño();
                case 6 -> limpiarConjunto();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }

        } while (option != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ MyHashSet ---");
        System.out.println("1. Agregar elemento");
        System.out.println("2. Verificar existencia");
        System.out.println("3. Eliminar elemento");
        System.out.println("4. Imprimir conjunto");
        System.out.println("5. Tamaño del conjunto");
        System.out.println("6. Limpiar conjunto");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    public static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingresa un número válido.");
            return -1;
        }
    }

    public static void agregarElemento() {
        System.out.print("Ingresa el elemento a agregar: ");
        String element = scanner.nextLine();
        set.add(element);
        System.out.println("Elemento agregado (o ya existía).");
    }

    public static void verificarElemento() {
        System.out.print("Ingresa el elemento a verificar: ");
        String element = scanner.nextLine();
        boolean existe = set.contains(element);
        System.out.println(existe
                ? "El conjunto contiene el elemento."
                : "El conjunto NO contiene el elemento.");
    }

    public static void eliminarElemento() {
        System.out.print("Ingresa el elemento a eliminar: ");
        String element = scanner.nextLine();
        set.remove(element);
        System.out.println("Elemento eliminado (si existía).");
    }

    public static void imprimirElementos() {
        System.out.println("Contenido del HashSet:");
        set.print();
    }

    public static void imprimirTamaño() {
        System.out.println("Tamaño actual del conjunto: " + set.size());
    }

    public static void limpiarConjunto() {
        set = new MyHashSet<>(10); 
        System.out.println("Conjunto limpiado.");
    }
    

    public static void main(String[] args) {
        ejecutarMenu();  
    }


}
