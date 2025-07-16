import java.util.Scanner;


public class ArrayHandler {
    static Scanner scanner = new Scanner(System.in);

    private int size = 0;
    private int[] array = new int[size];

    public ArrayHandler(){
        size = 0;
        array = new int[1];
    }

    public void leer(){
        if(size == 0){
            System.out.println("Arreglo vacio");
            return;
        }

        System.out.println("Elementos del arreglo");

        System.out.print("[");
        for(int i: array){
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public void agregarElemento(){
        if(size == array.length)
        {
            System.out.println("El arreglo está lleno. Creando nuevo arrreglo");
            int[] newArray = new int[array.length * 2];

            System.out.println("Copiando elementos");
            System.arraycopy(array, 0, newArray, 0, array.length);

            System.out.println("Arreglo creado");
            array = newArray;

            System.out.printf("Nuevo tamaño: %d%n", array.length);

        }

         while (true) { 
            try {
                System.out.println("Inserta nuevo elemento");
                int newValue = Integer.parseInt(scanner.nextLine());
                array[size] = newValue;
                size++;
                System.out.println("Elemento agregado");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Escribe un entero");
            }
        }

    }


    public void leerUnElemento() {

        while (true) { 
            try {
                System.out.println("¿Qué posición quieres obtener? (Recuerda que inicia en 0)");
                int indexToGet = Integer.parseInt(scanner.nextLine());
                System.out.printf("Datos recuperados del indice: %d%n", indexToGet);
                System.out.println("Valor: "+ array[indexToGet]);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public void actualizarUnElemento() {

        while (true) { 
            try {
                System.out.println("¿Qué posición quieres actualizar? (Recuerda que inicia en 0)");
                int indexToUpdate = Integer.parseInt(scanner.nextLine());
                System.out.println("Valor: "+ array[indexToUpdate]);
                System.out.println("¿Qué valor quieres poner en este índice?");
                int newValue = Integer.parseInt(scanner.nextLine());
                array[indexToUpdate] = newValue;
                System.out.println("El índice fue actualizado, el nuevo valor es: "+ newValue);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public void eliminarUnElemento() {

        while (true) { 
            try {
                System.out.println("¿Qué posición quieres eliminar? (Recuerda que inicia en 0)");
                int indexToUpdate = Integer.parseInt(scanner.nextLine());
                array[indexToUpdate] = 0;
                System.out.println("El índice fue eliminado");
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public static void showMenu(){
        System.out.println("-----------------------------------");
        System.out.println("1. Leer arreglo");
        System.out.println("2. Agregar un elemento al arreglo");
        System.out.println("3. Leer un elemento del arreglo");
        System.out.println("4. Actualizar un elemento del arreglo");
        System.out.println("5. Eliminar un elemento del arreglo");
        System.out.println("0. Salir");
        System.out.println("-----------------------------------");
    }
    public static void main(String[] args) {
            ArrayHandler arrayHandler = new ArrayHandler();

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("¿Qué quieres hacer?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 0 -> System.out.println("Saliendo....");
                    case 1 -> arrayHandler.leer();
                    case 2 -> arrayHandler.agregarElemento();
                    case 3 -> arrayHandler.leerUnElemento();
                    case 4 -> arrayHandler.actualizarUnElemento();
                    case 5 -> arrayHandler.eliminarUnElemento();
                    default -> System.out.println("Opción no soportada");
                }
            } catch (NumberFormatException e) {
                System.err.println("Por favor, elige una opción del menú");
            }
        } while(option != SALIR);

        scanner.close();
    }
}
