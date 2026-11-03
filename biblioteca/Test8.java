package biblioteca;

public class Test8 {
    public static void main(String[] args) {
        System.out.println("=== CÁLCULO DEL DETERMINANTE (3x3) ===");
        
        // Pedimos la matriz 3x3 por teclado
        int[][] matriz = basicas.fillFromKeyboard(3, 3);

        System.out.println("\nMatriz introducida:");
        basicas.print2DArray(matriz);

        // Calculamos el determinante
        int det = basicas.determinant(matriz);
        System.out.println("\nEl determinante de la matriz es: " + det);
    }
}