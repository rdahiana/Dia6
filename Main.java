public class Main {
    public static void main(String[] args) {
        // Instanciamos un objeto de la clase Cartas
        Cartas cartas = new Cartas();

        // En un array de String guardamos las cartas (generadas aleatoriamente) en orden
        String[] cartasOrdenadas = cartas.ordenarCartas(cartas.generarCartaAleatoria());

        for (int i = 0; i < cartasOrdenadas.length; i++) {
            System.out.println(" " + cartasOrdenadas[i]);
        }

        // AHORA VEREMOS A QUÉ JUGADA CORRESPONDE

        // Si los palos son iguales y los numeros estan en orden secuencial -->ESCALERA COLOR
        if (cartas.palosIguales(cartasOrdenadas) && cartas.cartasSecuenciales(cartasOrdenadas)){
            System.out.println("Escalera Color ");
            return;
        }
        // Si los palos no son iguales pero los numeros estan en orden secuencial -->ESCALERA
        else if (cartas.cartasSecuenciales(cartasOrdenadas)){
            System.out.println("Escalera ");
            return;
            // Si los palos son iguales pero los numeros NO estan en orden secuencial -->COLOR
        } else if (cartas.palosIguales(cartasOrdenadas)){
            System.out.println("Color ");
            return;
        }

        // Aca necesito que si se efectuó algun if de arriba ya termine el programa
        int[] repeticiones = cartas.contarRepeticiones(cartasOrdenadas);

        // Contador para llevar la cuenta de los números que se repiten dos veces
        int contador2 = 0;
        int contador3 = 0 ;

        for (int i = 0; i < 13; i++) {
            if (repeticiones[i] == 4){
                System.out.println("POKER");
                return;
            } else if (repeticiones[i] == 3) {
                contador3++;
            } else if (repeticiones[i] == 2) {
                contador2++; // Incrementar el contador de números repetidos dos veces
            }
        }

        // Verificar si hay más de un número que se repite
        if (contador2 == 1 && contador3 == 1) {
            System.out.println("Full");
            return;
        } else if (contador3 == 1) {
            System.out.println("Trio");
            return;
        } else if (contador2 == 2) {
            System.out.println("Par Doble");
            return;
        }
        else if (contador2 == 1) {
            System.out.println("Doble");
            return;
        }

        // Si no se cumplen las condiciones anteriores, significa que es una Carta Alta
        System.out.println("Carta Alta");
    }
}
