package JetBrains.NumericMatrixProcessor5;

import java.util.Scanner;

public class NumericMatrixProcessor5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            StateOfMenu choice = scanStateOfMenu(scanner, null);
            switch (choice) {
                case ADD_MATRICES -> addMatrices(scanner);
                case MULTIPLY_MATRIX_TO_A_CONSTANT -> multiplyMatrixToConstant(scanner);
                case MULTIPLY_MATRICES -> multiplyMatrices(scanner);
                case TRANSPOSE_MATRIX -> {
                    choice = scanStateOfMenu(scanner, choice);
                    switch (choice) {
                        case TRANSP_MAIN_DIAGONAL -> printMatrix(transpositionOverTheMainDiagonal(scanner));
                        case TRANSP_SIDE_DIAGONAL -> printMatrix(transpositionOverTheSideDiagonal(scanner));
                        case TRANSP_VERTICAL_LINE -> printMatrix(transpositionByVerticalLine(scanner));
                        case TRANSP_HORIZONTAL_LINE -> printMatrix(transpositionByHorizontalLine(scanner));
                        default -> System.out.println("Your option is incorrect!");
                    }
                }
                case EXIT -> exit = true;
                default -> System.out.println("Your option is incorrect!");
            }
        }
    }

    private static StateOfMenu scanStateOfMenu(Scanner scanner, StateOfMenu choice) {
        if (choice == null) {
            System.out.println();
            for (StateOfMenu value : StateOfMenu.values()) {
                if (value.getItemNumber() < 10) {
                    System.out.println(value.getItemName());
                }
            }
            System.out.print("Your choice: > ");
            choice = StateOfMenu.findByItemNumber(Integer.parseInt(scanner.next()));
        } else if (choice == StateOfMenu.TRANSPOSE_MATRIX){
            System.out.println();
            for (StateOfMenu value : StateOfMenu.values()) {
                if (value.getItemNumber() / 10 == choice.getItemNumber()) {
                    System.out.println(value.getItemName());
                }
            }
            System.out.print("Your choice: > ");
            choice = StateOfMenu.findByItemNumber(Integer.parseInt(choice.getItemNumber() + scanner.next()));
        }
        return choice;
    }
    
    public static double[][] scanMatrix(int n, int m, Scanner scanner) {
        double[][] matrix = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void addMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] A = scanMatrix(n, m, scanner);

        System.out.print("Enter size of second matrix: > ");
        if (n == scanner.nextInt() && m == scanner.nextInt()) {
            System.out.println("Enter second matrix:");
            double[][] B = scanMatrix(n, m, scanner);

            double[][] C = new double[n][m];
            System.out.println("The addition result is:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    C[i][j] = A[i][j] + B[i][j];
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }

    public static void multiplyMatrixToConstant(Scanner scanner) {
        System.out.print("Enter size of a matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter the matrix:");
        double[][] A = scanMatrix(n, m, scanner);

        System.out.print("Enter a constant: > ");
        final double C = scanner.nextDouble();

        double[][] B = new double[n][m];
        System.out.println("The multiplication result is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                B[i][j] = A[i][j] * C;
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void multiplyMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] A = scanMatrix(n, m, scanner);

        System.out.print("Enter size of second matrix: > ");
        if (m == scanner.nextInt()) {
            int k = scanner.nextInt();
            System.out.println("Enter second matrix:");
            double[][] B = scanMatrix(m, k, scanner);

            double[][] C = new double[n][k];
            System.out.println("The multiplication result is:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    for (int l = 0; l < m; l++) {
                        C[i][j] += A[i][l] * B[l][j];
                    }
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }

    public static double[][] transpositionOverTheMainDiagonal(Scanner scanner) {
        System.out.print("Enter size of a matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter the matrix:");
        double[][] A = scanMatrix(n, m, scanner);

        System.out.println("The result of transposition over the main diagonal is:");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                double temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }

    public static double[][] transpositionOverTheSideDiagonal(Scanner scanner) {
        System.out.print("Enter size of a matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter the matrix:");
        double[][] A = scanMatrix(n, m, scanner);

        System.out.println("The result of transposition over the side diagonal is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - i; j++) {
                double temp = A[i][j];
                A[i][j] = A[n - 1 - j][m - 1 - i];
                A[n - 1 - j][m - 1 - i] = temp;
            }
        }
        return A;
    }

    public static double[][] transpositionByVerticalLine(Scanner scanner) {
        System.out.print("Enter size of a matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter the matrix:");
        double[][] A = scanMatrix(n, m, scanner);

        System.out.println("The result of transposition by vertical line is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                double temp = A[i][j];
                A[i][j] = A[i][m - 1 - j];
                A[i][m - 1 - j] = temp;
            }
        }
        return A;
    }

    public static double[][] transpositionByHorizontalLine(Scanner scanner) {
        System.out.print("Enter size of a matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter the matrix:");
        double[][] A = scanMatrix(n, m, scanner);

        System.out.println("The result of transposition by horizontal line is:");
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                double temp = A[i][j];
                A[i][j] = A[n - 1 - i][j];
                A[n - 1 - i][j] = temp;
            }
        }
        return A;
    }
}

enum StateOfMenu {
    ADD_MATRICES(1, "1. Add matrices"),
    MULTIPLY_MATRIX_TO_A_CONSTANT(2, "2. Multiply matrix to a constant"),
    MULTIPLY_MATRICES(3, "3. Multiply matrices"),
    TRANSPOSE_MATRIX(4, "4. Transpose matrix"),
    TRANSP_MAIN_DIAGONAL(41, "1. Main diagonal"),
    TRANSP_SIDE_DIAGONAL(42, "2. Side diagonal"),
    TRANSP_VERTICAL_LINE(43, "3. Vertical line"),
    TRANSP_HORIZONTAL_LINE(44, "4. Horizontal line"),
    EXIT(0, "0. Exit");

    private final int itemNumber;
    private final String itemName;

    StateOfMenu(int itemNumber, String itemName) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public static StateOfMenu findByItemNumber(int itemNumber) {
        for (StateOfMenu value: values()) {
            if (itemNumber == value.itemNumber) {
                return value;
            }
        }
		System.out.println("Your option is incorrect!");
        return null;
    }
}