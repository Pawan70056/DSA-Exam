// Design multithreaded algorithm of matrix multiplication.


// Answer:


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class qno32MatrixMultiplication {

    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors(); // Number of available processors

    public static void main(String[] args) {
        int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] matrix2 = { { 7, 8 }, { 9, 10 }, { 11, 12 } };

        int[][] result = multiplyMatrices(matrix1, matrix2);
        printMatrix(result);
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                executor.submit(new MatrixMultiplicationTask(matrix1, matrix2, result, i, j));
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class MatrixMultiplicationTask implements Runnable {

    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] result;
    private final int row;
    private final int col;

    public MatrixMultiplicationTask(int[][] matrix1, int[][] matrix2, int[][] result, int row, int col) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.row = row;
        this.col = col;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < matrix1[0].length; i++) {
            sum += matrix1[row][i] * matrix2[i][col];
        }
        result[row][col] = sum;
    }
}
