package hash_tables;

import java.util.Map;
import java.util.Scanner;

public class HashMapHandler {

    static Scanner scanner = new Scanner(System.in);

    public static void print(Map<String, Integer> hashMap){
        System.out.println("Contenido actual:");
        if(hashMap.isEmpty()){
            System.out.println("El hashMap está vacío.");
        }else{
            for(Map.Entry<String, Integer> entry: hashMap.entrySet()){
                System.out.println("Clave: " + entry.getKey() + "| Valor: " + entry.getValue());
            }
        }
    }
    public static void put(Map<String, Integer> hashMap) {
        while (true) {
            try {
                System.out.println("Inserta la clave del nuevo elemento:");
                String key = scanner.nextLine();
                System.out.println("Inserta el valor (entero) del nuevo elemento:");
                int value = Integer.parseInt(scanner.nextLine());
                hashMap.put(key, value);
                System.out.println("Elemento agregado.");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Debes ingresar un número entero.");
            }
        }
    }

    public static void get(Map<String, Integer> hashMap) {
        System.out.println("Inserta la clave del elemento que deseas obtener:");
        String key = scanner.nextLine();
        if (hashMap.containsKey(key)) {
            System.out.println("Valor asociado: " + hashMap.get(key));
        } else {
            System.out.println("El elemento no existe.");
        }
    }

    public static void showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Mostrar HashMap");
        System.out.println("2. Agregar elemento");
        System.out.println("3. Obtener elemento");
        System.out.println("4. Eliminar elemento");
        System.out.println("0. Salir");
        System.out.println("-----------------------------------");
    }

    public static void remove(Map<String, Integer> hashMap) {
        System.out.println("Inserta la clave del elemento que deseas eliminar:");
        String key = scanner.nextLine();
        if (hashMap.remove(key) != null) {
            System.out.println("Elemento eliminado.");
        } else {
            System.out.println("No se encontró la clave.");
        }
    }

    public static void main(String[] args) {
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        final int EXIT = 0;
        int option = -1;

        do {
            showMenu();
            System.out.print("Selecciona una opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> print(map);
                    case 2 -> put(map);
                    case 3 -> get(map);
                    case 4 -> remove(map);
                    case 0 -> System.out.println("Saliendo del programa.");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Por favor ingresa un número válido.");
            }
        } while (option != EXIT);

        scanner.close();
    }
}
