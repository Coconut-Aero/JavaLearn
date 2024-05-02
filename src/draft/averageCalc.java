package draft;

import java.util.Scanner;

public class averageCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of numbers: ");
        int n = sc.nextInt();
        int[]  arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double average = (double) sum / n;
        System.out.println("The average is " + average);
    }
}
