package practice;

import java.util.Scanner;

public class sumColumnTest {
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (double[] doubles : m) {
            sum += doubles[columnIndex];
        }
        return sum;
    }

    public static void main(String[] args) {
        double[][] m = new double[3][4];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3-by-4 matrix row by row: ");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++){
                m[row][col] =input.nextDouble();
            }
        }
        for (int columnIndex = 0; columnIndex <4; columnIndex++) {
            double sum = sumColumn(m, columnIndex);
            System.out.println("Sum of elements at column " + columnIndex + " is " + sum);
        }
    }
}
