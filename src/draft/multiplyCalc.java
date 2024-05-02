package draft;

import java.util.Scanner;

public class multiplyCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextInt();
        long b = input.nextInt();
        long c = a * b;
        System.out.print(c);
    }
}
