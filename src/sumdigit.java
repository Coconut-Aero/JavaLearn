import java.util.*;

public class sumdigit {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Create Scanner;
        System.out.print("Enter a number between 0 and 1000:");
        int num = input.nextInt();
        // Read the Number;
        int num1 = num % 10;
        int num2 = num / 10 % 10;
        int num3 = num / 100 % 10;
        int num4 = num / 1000;
        int result = num1 + num2 + num3 + num4;
        System.out.println("The sum of the digits is " + result);
    }
}
