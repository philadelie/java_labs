package ntudp.psj.lab2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    static final int MIN_MATRIX_POINT = 0;
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

        printMatrix(matrix, rows);
        System.out.println("Min: " + findMatrixMin(matrix, rows, cols));
        System.out.println("Max: " + findMatrixMax(matrix, rows, cols));
        System.out.printf("Arithmetic mean: %.2f%n", calculateMatrixArithmeticMean(matrix, rows, cols));
        System.out.printf("Geometric mean: %.2f%n", calculateMatrixGeometricMean(matrix, rows, cols));
    }

    private static boolean askIfRandomMatrix() {
        String[] yesAnswers = {"y", "yes"};
        String[] noAnswers = {"n", "no"};

        while (true) {
            System.out.print("Do you want to generate matrix randomly? [y/n]: ");
            String answer = sc.next().toLowerCase();

            if (Arrays.asList(yesAnswers).contains(answer)) return true;
            if (Arrays.asList(noAnswers).contains(answer)) return false;
            System.out.println("Don't understand. Try again.");
        }
    }

    private static int defineMatrixSize(String dimension) {
        String str = String.format("Enter number of %s [<=%d]: ", dimension, MAX_MATRIX_SIZE);
        return checkNumericInput(str, 0, MAX_MATRIX_SIZE);
    }

    private static int checkNumericInput(String outputMessage, int min, int max) {
        while (true) {
            System.out.print(outputMessage);
            if (sc.hasNextInt()) {
                int x = sc.nextInt();
                if (x > min && x <= max) return x;
                else continue;
            }
            sc.next();
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
        System.out.printf("Now, enter the matrix' elements values [%d; %d].%n", MIN_MATRIX_POINT, MAX_MATRIX_POINT);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String str = String.format("[%d,%d] = ", i + 1, j + 1);
                arr[i][j] = checkNumericInput(str, MIN_MATRIX_POINT, MAX_MATRIX_POINT);
            }
        }
    }

    private static void printMatrix(int[][] arr, int rows) {
        System.out.printf("%nMatrix:%n");
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    private static int findMatrixMin(int[][] arr, int rows, int cols) {
        int min = arr[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] < min) min = arr[i][j];
            }
        }
        return min;
    }

    private static int findMatrixMax(int[][] arr, int rows, int cols) {
        int max = arr[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] > max) max = arr[i][j];
            }
        }
        return max;
    }

    private static double calculateMatrixArithmeticMean(int[][] arr, int rows, int cols) {
        double sum = 0.0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                sum += arr[i][j];
        }
        return sum / (rows * cols);
    }

    private static double calculateMatrixGeometricMean(int[][] arr, int rows, int cols) {
        double product = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                product *= arr[i][j];
        }
        return Math.pow(product, 1.0 / (rows * cols));
    }
}
