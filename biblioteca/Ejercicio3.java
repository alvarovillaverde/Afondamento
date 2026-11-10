package biblioteca;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 3: TRASPUESTA, SIMETRÍA Y TRAZA (3x3) ===");

        // 1. Pedir matriz 3x3 por teclado
        int[][] matriz = basicas.fillFromKeyboard(3, 3);

        System.out.println("Matriz original:");
        basicas.print2DArray(matriz);

        // 2. Mostrar la matriz traspuesta
        int[][] traspuesta = basicas.transpose(matriz);
        System.out.println("Matriz traspuesta:");
        basicas.print2DArray(traspuesta);

        // 3. Indicar si es simétrica
        boolean simetrica = basicas.esSimetrica(matriz);
        System.out.println("¿La matriz es simétrica?: " + (simetrica ? "Sí" : "No"));

        // 4. Calcular y mostrar la traza
        int traza = basicas.trace(matriz);
        System.out.println("La traza de la matriz es: " + traza);
    }
}