package thread;

import java.util.Scanner;

public class Questao2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];

        System.out.println("Preencha a primeira matriz (3x3):");
        fillMatrix(scanner, matrix1);

        System.out.println("Preencha a segunda matriz (3x3):");
        fillMatrix(scanner, matrix2);

        int[][] resultMatrix = multiplyMatrices(matrix1, matrix2);

        System.out.println("Resultado da multiplicação:");
        printMatrix(resultMatrix);

        scanner.close();
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[3][3];
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[row][j] += matrix1[row][k] * matrix2[k][j];
                    }
                }
            });
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
