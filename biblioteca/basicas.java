package biblioteca;

import java.util.Scanner;

public class basicas {

    // Función que pide una matriz de enteros por teclado
    public static int[][] fillFromKeyboard(int rows, int cols) {
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[rows][cols];
        System.out.println("Añade: " + (rows * cols) + " numeros");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Elemento [" + i + "][" + j + "]");
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }

    // Función que traspone una matriz de enteros
    public static int[][] transpose(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = array[i][j];
            }
        }
        return transposed;
    }

    // Calcula la traza de una matriz cuadrada
    public static int trace(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        if (rows != cols) {
            throw new IllegalArgumentException("La matriz debe ser cuadrada para calcular la traza");
        }

        int trace = 0;
        for (int i = 0; i < rows; i++) {
            trace += array[i][i];
        }
        return trace;
    }

    // Comprueba si una matriz es simétrica
    public static boolean esSimetrica(int[][] array) {
        if (array == null || array.length == 0) return false;

        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] == null || array[i].length != n) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i][j] != array[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Función que imprime una matriz
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    // Comprueba si los elementos fuera de la diagonal son cero
    public static boolean verificarFueraDiagonal(int[][] array) {
        if (array == null || array.length == 0) return false;

        int numFilas = array.length;
        for (int i = 0; i < numFilas; i++) {
            if (array[i] == null || array[i].length != numFilas) {
                return false;
            }
        }

        for (int k = 0; k < numFilas; k++) {
            for (int k2 = 0; k2 < numFilas; k2++) { // Corregido: sin -1
                if (k != k2 && array[k][k2] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Función para sumar dos matrices de enteros
    public static int[][] sum(int[][] array1, int[][] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException("Las matrices no pueden ser nulas o estar vacías.");
        }

        int rows = array1.length;
        int cols = array1[0].length;

        if (rows != array2.length || cols != array2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para poder sumarse.");
        }

        int[][] arraySumado = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arraySumado[i][j] = array1[i][j] + array2[i][j];
            }
        }
        return arraySumado;
    }

    // Función de resta de dos matrices (array1 - array2)
    public static int[][] subtract(int[][] array1, int[][] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException("Las matrices no pueden ser nulas o estar vacías.");
        }

        int rows = array1.length;
        int cols = array1[0].length;

        if (rows != array2.length || cols != array2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para poder restarse.");
        }

        int[][] arrayRestado = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arrayRestado[i][j] = array1[i][j] - array2[i][j];
            }
        }
        return arrayRestado;
    }

    // Multiplicación de 2 matrices
    public static int[][] multiplicar2(int[][] array1, int[][] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException("Las matrices no pueden ser nulas ni estar vacías.");
        }
        if (array1[0].length != array2.length) {
            throw new IllegalArgumentException("Las columnas de la primera matriz deben coincidir con las filas de la segunda.");
        }

        int[][] result = new int[array1.length][array2[0].length];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                for (int k = 0; k < array1[0].length; k++) {
                    result[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }
        return result;
    }

    // Multiplicación de 3 matrices: (A * B) * C
    public static int[][] multiplicar3(int[][] a, int[][] b, int[][] c) {
        int[][] ab = multiplicar2(a, b);
        return multiplicar2(ab, c);
    }

    // Comprueba la igualdad exacta entre dos matrices
    public static boolean matricesIguales(int[][] a, int[][] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length || a[0].length != b[0].length) return false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Genera la submatriz eliminando una fila y una columna
    public static int[][] minor(int[][] array, int row, int col) {
        int rows = array.length;
        int cols = array[0].length;
        int[][] minor = new int[rows - 1][cols - 1];
        for (int i = 0, mi = 0; i < rows; i++) {
            if (i == row) continue;
            for (int j = 0, mj = 0; j < cols; j++) {
                if (j == col) continue;
                minor[mi][mj] = array[i][j];
                mj++;
            }
            mi++;
        }
        return minor;
    }

    // Calcula el determinante de cualquier matriz cuadrada
    public static int determinant(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        if (rows != cols) {
            throw new IllegalArgumentException("La matriz debe ser cuadrada para calcular el determinante.");
        }

        if (rows == 1) return array[0][0];
        if (rows == 2) return (array[0][0] * array[1][1]) - (array[0][1] * array[1][0]);

        int det = 0;
        for (int j = 0; j < cols; j++) {
            int[][] subMatrix = minor(array, 0, j);
            int signo = (j % 2 == 0) ? 1 : -1;
            det += signo * array[0][j] * determinant(subMatrix);
        }
        return det;
    }
}