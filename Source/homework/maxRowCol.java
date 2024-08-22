package homework;

import practice.galtonBoard;

public class maxRowCol {
    public static void main(String[] args) {
        boolean[][] matrix1 = new boolean[4][4];
        int[][] matrix2 = new int[4][4];
        int[] matrixCol = new int[4];
        int[] matrixRow = new int[4];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = galtonBoard.BooleanRandom();
            }
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j]) {
                    System.out.print("0");
                    matrix2[i][j] = 0;
                } else {
                    System.out.print("1");
                    matrix2[i][j] = 1;
                }
            }
            System.out.println();
        }
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrixCol[i] += matrix2[i][j];
            }
        }
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrixRow[i] += matrix2[j][i];
            }
        }
        int ColMax = findMax(matrixCol);
        int RowMax = findMax(matrixRow);
        System.out.println("The largest column index: " + (ColMax+1));
        System.out.println("The largest row index: " + (RowMax+1));
    }

    public static int findMax(int[] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] > matrix[result]) {
                result = i;
            }
        }
        return result;
    }
}
