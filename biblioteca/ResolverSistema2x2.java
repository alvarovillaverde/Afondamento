package biblioteca;

public class ResolverSistema2x2 {
    public static void main(String[] args) {
        System.out.println("=== RESOLUCIÓN DE SISTEMA 2x2 (A * X = b) ===");

        System.out.println("\n--- Introduce la matriz de coeficientes A (2x2) ---");
        int[][] a = basicas.fillFromKeyboard(2, 2);

        System.out.println("\n--- Introduce los términos independientes b (2x1) ---");
        int[][] b = basicas.fillFromKeyboard(2, 1);

        System.out.println("\nMatriz A:");
        basicas.print2DArray(a);

        System.out.println("\nVector b:");
        basicas.print2DArray(b);

        double[][] aInversa = basicas.inverse(a);

        System.out.println("\nMatriz Inversa (A^-1):");
        basicas.print2DArrayDouble(aInversa);

        double[][] x = multiplicarDoubleInt(aInversa, b);

        System.out.println("\n=== SOLUCIÓN DEL SISTEMA ===");
        System.out.printf("x = %.2f\n", x[0][0]);
        System.out.printf("y = %.2f\n", x[1][0]);
    }

    public static double[][] multiplicarDoubleInt(double[][] array1, int[][] array2) {
        if (array1[0].length != array2.length) {
            throw new IllegalArgumentException("Dimensiones incompatibles para multiplicar.");
        }

        int rowsA = array1.length;
        int colsB = array2[0].length;
        int shared = array1[0].length;
        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < shared; k++) {
                    result[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }
        return result;
    }
}