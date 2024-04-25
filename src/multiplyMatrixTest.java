import java.util.Scanner;

public class multiplyMatrixTest {
    public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                for (int k = 0; k < matrix2[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix1 = new double[3][3];
        double[][] matrix2 = new double[3][3];
        System.out.println("Matrix 1: ");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = input.nextDouble();
            }
        }
        System.out.println("Matrix 2: ");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = input.nextDouble();
            }
        }
        double[][] result = multiplyMatrix(matrix1, matrix2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%5.1f",matrix1[i][j]);
            }
            if(i==1){
                System.out.print("   *   ");
            }else System.out.print("       ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%5.1f",matrix2[i][j]);
            }
            if(i==1){
                System.out.print("   =   ");
            }else System.out.print("       ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%5.1f",result[i][j]);
            }
            System.out.println();
        }
    }
}
