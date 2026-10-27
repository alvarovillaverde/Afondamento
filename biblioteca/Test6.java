package biblioteca;

public class Test6 {
    public static void main(String[] args) {
        // Matriz A de 2x3
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Matriz B de 3x2
        int[][] b = {
            {7, 8},
            {9, 1},
            {2, 3}
        };

        System.out.println("=== MATRIZ A (2x3) ===");
        basicas.print2DArray(a);

        System.out.println("\n=== MATRIZ B (3x2) ===");
        basicas.print2DArray(b);

        // Multiplicación A * B -> Resultado esperado de 2x2
        System.out.println("\n=== RESULTADO MULTIPLICACIÓN (A * B) ===");
        int[][] resultado = basicas.multiplicar(a, b);
        basicas.print2DArray(resultado);
    }
}