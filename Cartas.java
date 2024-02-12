import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Cartas {
    int[] valoresNumericos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    String[] palos = {"S", "C", "H", "D"};

    public Cartas() {
    }

    public String[] generarCartaAleatoria() {
        Random random = new Random();
        String[] cartas = new String[5]; // Inicializamos un array con 5 elementos
        for (int i = 0; i < 5; i++) {
            int indiceValor = random.nextInt(valoresNumericos.length);
            int indicePalo = random.nextInt(palos.length);
            cartas[i] = valoresNumericos[indiceValor] + palos[indicePalo];
        }
        return cartas;
    }

    public String[] ordenarCartas(String[] cartas) {
        Arrays.sort(cartas, new Comparator<String>() {
            @Override
            public int compare(String carta1, String carta2) {
                int valor1 = Integer.parseInt(carta1.substring(0, carta1.length() - 1));
                int valor2 = Integer.parseInt(carta2.substring(0, carta2.length() - 1));
                return Integer.compare(valor1, valor2);
            }
        });
        return cartas;
    }

    public boolean palosIguales(String[] cartas) {
        char primerCaracter = cartas[0].charAt(1);

        for (int i = 1; i < cartas.length; i++) {
            char letra = cartas[i].charAt(1);
            if (letra != primerCaracter) {
                return false;
            }
        }
        return true;
    }

    public boolean cartasSecuenciales(String[] cartas) {

        // Almacenar el valor numérico del primer elemento del array
        int primerValor = Character.getNumericValue(cartas[0].charAt(0));

        // Almacenar el valor numérico del último elemento del array
        int ultimoValor = Character.getNumericValue(cartas[cartas.length - 1].charAt(0));

        int c = 1;

        // Si el primer valor es 10 o el último valor es 1, ajustar c a 2 para considerar el As
        if (primerValor == 10 || ultimoValor == 1) {
            c = 2;
        }

        // Iterar sobre el array de cartas hasta el penúltimo elemento (teniendo en cuenta el ajuste con c)
        for (int i = 0; i < cartas.length - c; i++) {
            // Almacenar el valor numérico del elemento en la posición i
            int valor1 = Character.getNumericValue(cartas[i].charAt(0));

            // Almacenar el valor numérico del elemento en la posición i+1
            int valor2 = Character.getNumericValue(cartas[i + 1].charAt(0));

            // Verificar si el valor numérico del siguiente elemento no es igual al valor numérico del elemento actual + 1
            if (valor2 != valor1 + 1) {
                return false; // Si no lo es, retornar false, ya que las cartas no están en orden secuencial
            }
        }
        // Si todas las comparaciones pasan sin retornar false, retornar true
        return true;
    }


    public int[] contarRepeticiones(String[] cartas) {
        // Crear un mapa para almacenar la cantidad de repeticiones de cada número
        Map<Integer, Integer> repeticiones = new HashMap<>();

        // Iterar sobre el arreglo de cartas y contar las repeticiones de cada número
        for (String carta : cartas) {
            // Extraer el número completo de la carta
            String numeroString = carta.substring(0, carta.length() - 1);
            int numero = Integer.parseInt(numeroString);
            // Incrementar la cantidad de repeticiones del número en el mapa repeticiones
            repeticiones.put(numero, repeticiones.getOrDefault(numero, 0) + 1);
        }

        // Crear un array para almacenar la cantidad de repeticiones de cada número
        int[] repeticionesArray = new int[13]; // 13 porque hay 13 numeros

        // Obtener la cantidad de repeticiones de cada número del mapa y almacenarla en el array
        for (int i = 1; i <= 13; i++) {
            repeticionesArray[i - 1] = repeticiones.getOrDefault(i, 0);
        }

        return repeticionesArray;
    }


}