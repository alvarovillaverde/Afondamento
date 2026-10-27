package biblioteca;

public class Test5 {
    public static void main(String[] args) {
        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] m2 = {
            {7, 8, 9},
            {1, 2, 3}
        };

        System.out.println("=== MATRIZ 1 ===");
        basicas.print2DArray(m1);

        System.out.println("\n=== MATRIZ 2 ===");
        basicas.print2DArray(m2);

        // 1. Prueba de Suma
        System.out.println("\n=== RESULTADO DE LA SUMA (m1 + m2) ===");
        int[][] resultadoSuma = basicas.sum(m1, m2);
        basicas.print2DArray(resultadoSuma);

        // 2. Prueba de Resta
        System.out.println("\n=== RESULTADO DE LA RESTA (m1 - m2) ===");
        int[][] resultadoResta = basicas.subtract(m1, m2);
        basicas.print2DArray(resultadoResta);
    }
}