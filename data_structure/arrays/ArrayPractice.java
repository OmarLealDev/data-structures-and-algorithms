package arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayPractice {
    private static String saludo = "Hola Mundo";

    public static void main(String[] args) {
        StringBuilder saludoReversa = new StringBuilder(saludo).reverse();
        String saludoAlReves = "";

        int[] numeros = {1, 2, 3, 4, 5};

        int[] numerosInvertido = new int[5];


        for (int i = numeros.length -1; i >= 0; i--){
            // System.out.println(numeros[i]);
            numerosInvertido[i] = numeros[i];
        }

        for(int numero: numerosInvertido){
            System.out.println(numero);
        }

        // for(int i = saludo.length() -1; i >= 0; i--){
        //     saludoAlReves +=  saludo.charAt(i);
        // }
        // System.out.println(saludoAlReves);

        // System.out.println(saludoReversa);
    }
}
