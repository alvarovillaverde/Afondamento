package biblioteca;

import java.util.Scanner;

public class basicas {
    //funcion que pide una matriz de enteros por teclado
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

    //funcion que traspone una matriz de enteros
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

    public static boolean esSimetrica(int[][] array) {
        // Validar si la matriz no es nula ni está vacía
        if (array == null || array.length == 0) {
            return false;
        }

        int n = array.length;

        // 1. Comprobar si es cuadrada
        for (int i = 0; i < n; i++) {
            if (array[i] == null || array[i].length != n) {
                return false; // Si alguna fila no coincide con 'n', no es cuadrada
            }
        }

        // 2. Comprobar la simetría (solo recorremos los elementos por encima de la diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i][j] != array[j][i]) {
                    return false; // Al encontrar la primera diferencia, sabemos que no es simétrica
                }
            }
        }

        return true; // Pasó todas las comprobaciones correctamente
    }

    //funcion que imprime una matriz
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static boolean verificarFueraDiagonal(int[][] array) {
        // Validar si la matriz no es nula ni está vacía
        if (array == null || array.length == 0) {
            return false;
        }

        int numFilas = array.length;

        // 1. Comprobar si es cuadrada
        for (int i = 0; i < numFilas; i++) {
            if (array[i] == null || array[i].length != numFilas) {
                return false; // Si alguna fila no coincide con 'n', no es cuadrada
            }
        }

        // 2. Recorrer la matriz para verificar los elementos fuera de la diagonal
        for (int k = 0; k < numFilas; k++) {
            for (int k2 = 0; k2 < numFilas-1; k2++) {
                if (k != k2) {
                    if (array[k][k2] != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Función para sumar dos matrices de enteros
    public static int[][] sum(int[][] array1, int[][] array2) {
        // 1. Validaciones de nulos o matrices vacías
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException("Las matrices no pueden ser nulas o estar vacías.");
        }

        int rows = array1.length;
        int cols = array1[0].length;

        // 2. Comprobar que ambas matrices tengan las mismas dimensiones
        if (rows != array2.length || cols != array2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para poder sumarse.");
        }

        int[][] arraySumado = new int[rows][cols];

        // 3. Sumar elemento a elemento
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arraySumado[i][j] = array1[i][j] + array2[i][j];
            }
        }

        return arraySumado;
    }

    // Función contraria: Resta de dos matrices (array1 - array2)
        public static int[][] subtract(int[][] array1, int[][] array2) {
        // 1. Validaciones de nulos o matrices vacías
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException("Las matrices no pueden ser nulas o estar vacías.");
        }

        int rows = array1.length;
        int cols = array1[0].length;

        // 2. Comprobar que ambas matrices tengan las mismas dimensiones
        if (rows != array2.length || cols != array2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para poder restarse.");
        }

        int[][] arrayRestado = new int[rows][cols];

        // 3. Restar elemento a elemento
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arrayRestado[i][j] = array1[i][j] - array2[i][j];
            }
        }

        return arrayRestado;
    }

    public static int[][] multiplicar2(int[][] array1, int[][] array2) {
        // Validación de nulos y dimensiones
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException("Las matrices no pueden ser nulas ni estar vacías.");
        }
        if (array1[0].length != array2.length) {
            throw new IllegalArgumentException("Las columnas de la primera matriz deben coincidir con las filas de la segunda.");
        }

        int[][] result = new int[array1.length][array2[0].length];

        // Algoritmo de multiplicación
        for (int i = 0; i < array1.length; i++) {           // Filas de A
            for (int j = 0; j < array2[0].length; j++) {       // Columnas de B
                for (int k = 0; k < array1[0].length; k++) {   // Elementos compartidos
                    result[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }

        return result;
    }

    // Método para multiplicar tres matrices: (A * B) * C
    public static int[][] multiplicar3(int[][] a, int[][] b, int[][] c) {
        // 1. Multiplicamos A por B (aquí dentro ya se validan nulos y que colsA == filasB)
        int[][] ab = multiplicar2(a, b);

        // 2. El resultado (ab) lo multiplicamos por C (se valida que colsB == filasC)
        int[][] resultadoFinal = multiplicar2(ab, c);

        // El resultado final tendrá dimensiones: filas de A x columnas de C
        return resultadoFinal;
    }
}