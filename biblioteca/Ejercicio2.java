package biblioteca;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: PROPIEDAD ASOCIATIVA DE MULTIPLICACIÓN ===");
        
        // Se piden tres matrices con dimensiones compatibles para multiplicar:
        // A(2x3), B(3x2) y C(2x2)
        System.out.println("--- Matriz A (2x3) ---");
        int[][] a = basicas.fillFromKeyboard(2, 3);

        System.out.println("--- Matriz B (3x2) ---");
        int[][] b = basicas.fillFromKeyboard(3, 2);

        System.out.println("--- Matriz C (2x2) ---");
        int[][] c = basicas.fillFromKeyboard(2, 2);

        // Imprimir matrices introducidas
        System.out.println("Matriz A:");
        basicas.print2DArray(a);
        System.out.println("Matriz B:");
        basicas.print2DArray(b);
        System.out.println("Matriz C:");
        basicas.print2DArray(c);

        // Cálculo de (A x B) x C
        int[][] axb = basicas.multiplicar2(a, b);
        int[][] ladoIzquierdo = basicas.multiplicar2(axb, c);

        // Cálculo de A x (B x C)
        int[][] bxc = basicas.multiplicar2(b, c);
        int[][] ladoDerecho = basicas.multiplicar2(a, bxc);

        System.out.println("=== RESULTADO (A x B) x C ===");
        basicas.print2DArray(ladoIzquierdo);

        System.out.println("=== RESULTADO A x (B x C) ===");
        basicas.print2DArray(ladoDerecho);

        // Comprobación de la propiedad asociativa con matricesIguales
        boolean esIgual = basicas.matricesIguales(ladoIzquierdo, ladoDerecho);
        System.out.println("¿Se cumple la propiedad asociativa?: " + esIgual);
    }
}