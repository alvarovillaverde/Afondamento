package biblioteca;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: DETERMINANTE MATRIZ 4x4 ===");
        
        // 1. Pedir matriz 4x4 por teclado
        int[][] matriz = basicas.fillFromKeyboard(4, 4);

        // 2. Mostrar la matriz introducida
        System.out.println("Matriz 4x4 introducida:");
        basicas.print2DArray(matriz);

        // 3. Calcular y mostrar el determinante
        int det = basicas.determinant(matriz);
        System.out.println("El valor del determinante es: " + det);
    }
}