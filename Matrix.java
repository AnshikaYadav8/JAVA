import java.util.Scanner;

class MatrixOperations {
    public static void inputMatrix(int[][] matrix, Scanner sc) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void addMatrices(int[][] a, int[][] b, int[][] result) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
    }

    public static void subtractMatrices(int[][] a, int[][] b, int[][] result) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
    }

    public static void multiplyMatrices(int[][] a, int[][] b, int[][] result) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = new int[2][2];
        int[][] result = new int[2][2];
        
        System.out.println("Enter elements of first 2x2 matrix:");
        inputMatrix(matrix1, sc);
        System.out.println("Enter elements of second 2x2 matrix:");
        inputMatrix(matrix2, sc);
        
        addMatrices(matrix1, matrix2, result);
        System.out.println("Addition of Matrices:");
        displayMatrix(result);
        
        subtractMatrices(matrix1, matrix2, result);
        System.out.println("Subtraction of Matrices:");
        displayMatrix(result);
        
        multiplyMatrices(matrix1, matrix2, result);
        System.out.println("Multiplication of Matrices:");
        displayMatrix(result);
        
        sc.close();
    }
}
