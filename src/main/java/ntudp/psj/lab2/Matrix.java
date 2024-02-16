package ntudp.psj.lab2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    static final int MIN_MATRIX_POINT = -100;
    static final int MAX_MATRIX_POINT = 100;
    static final int MAX_MATRIX_SIZE = 20;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRandomMatrix = askIfRandomMatrix();
        int rows = defineMatrixSize("rows");
        int cols = defineMatrixSize("columns");
        int[][] matrix = new int[rows][cols];

        if (isRandomMatrix) generateRandomMatrix(matrix, rows, cols);
        else inputMatrixValues(matrix, rows, cols);

        printMatrix(matrix, rows, cols);
        System.out.println("Min: " + findMatrixMin(matrix, rows, cols));
        System.out.println("Max: " + findMatrixMax(matrix, rows, cols));
        System.out.println("Arithmetic mean: " + calculateMatrixArithmeticMean(matrix, rows, cols));
        System.out.println("Geometric mean: " + calculateMatrixGeometricMean(matrix, rows, cols));
    }

    private static boolean askIfRandomMatrix() {
        String[] yesAnswers = {"y", "yes"};
        String[] noAnswers = {"n", "no"};

        while (true) {
            System.out.print("Do you want to generate matrix randomly? [y/n]: ");
            String answer = sc.next().toLowerCase();

            if (Arrays.asList(yesAnswers).contains(answer)) return true;
            else if (Arrays.asList(noAnswers).contains(answer)) return false;
            else System.out.println("Don't understand. Try again.");
        }
    }

    private static int defineMatrixSize(String dimension) {
        while (true) {
            System.out.printf("Enter the number of %s: ", dimension);
            int size = sc.nextInt();
            if (size > 0 && size <= MAX_MATRIX_SIZE) return size;
            else System.out.println("Invalid input. Please enter a number between 1 and " + MAX_MATRIX_SIZE);
        }
    }

    private static void generateRandomMatrix(int[][] arr, int rows, int cols) {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = rand.nextInt(MAX_MATRIX_POINT - MIN_MATRIX_POINT + 1) + MIN_MATRIX_POINT;
            }
        }
    }

    private static void inputMatrixValues(int[][] arr, int rows, int cols) {
        System.out.println("Now, enter the matrix' elements values [-100; 100].");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.printf("%d,%d = ", i + 1, j + 1);
                    if (sc.hasNextInt()) {
                        int x = sc.nextInt();
                        if (x >= MIN_MATRIX_POINT && x <= MAX_MATRIX_POINT) {
                            arr[i][j] = x;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void printMatrix(int[][] arr, int rows, int cols) {
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    private static int findMatrixMin(int[][] arr, int rows, int cols) {
        int min = arr[0][0];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] < min) min = arr[i][j];
            }
        }
        return min;
    }

    private static int findMatrixMax(int[][] arr, int rows, int cols) {
        int max = arr[0][0];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] > max) max = arr[i][j];
            }
        }
        return max;
    }

    private static float calculateMatrixArithmeticMean(int[][] arr, int rows, int cols) {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += arr[i][j];
            }
        }
        return (float)sum / (rows * cols);
    }

    private static float calculateMatrixGeometricMean(int[][] arr, int rows, int cols) {
        int product = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                product *= arr[i][j];
            }
        }
        return (float)Math.pow(product, 1.0 / (rows * cols));
    }
}
