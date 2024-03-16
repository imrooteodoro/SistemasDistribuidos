package thread;

import java.util.Scanner;

public class Questao3{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de linhas da matriz: ");
        int rows = scanner.nextInt();
        System.out.print("Digite o número de colunas da matriz: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Preencha a matriz:");
        fillMatrix(scanner, matrix);

        int[][] transposedMatrix = transposeMatrix(matrix);

        System.out.println("Matriz transposta:");
        printMatrix(transposedMatrix);

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

    private static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        Thread[] threads = new Thread[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            final int col = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < matrix.length; j++) {
                    transposedMatrix[col][j] = matrix[j][col];
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

        return transposedMatrix;
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
