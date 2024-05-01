package homework;

import java.util.*;
public class triangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Create Scanner;
        System.out.println("Enter the coordinates of three points separated by spaces");
        System.out.println("like x1 y1 x2 y2 x3 y3");
        System.out.print("x1:");
        double x1 = input.nextDouble();
        System.out.print("y1:");
        double y1 = input.nextDouble();
        System.out.print("x2:");
        double x2 = input.nextDouble();
        System.out.print("y2:");
        double y2 = input.nextDouble();
        System.out.print("x3:");
        double x3 = input.nextDouble();
        System.out.print("y3:");
        double y3 = input.nextDouble();
        //Read the coordinates of the points, then calculate the length of lines.

        double line1x = x1 - x2;
        double line1y = y1 - y2;
        double line2x = x2 - x3;
        double line2y = y2 - y3;
        double line3x = x3 - x1;
        double line3y = y3 - y1;
        //Calculate the sub of coordinates.

        double line1x2 = Math.pow(line1x,2);
        double line1y2 = Math.pow(line1y,2);
        double line2x2 = Math.pow(line2x,2);
        double line2y2 = Math.pow(line2y,2);
        double line3x2 = Math.pow(line3x,2);
        double line3y2 = Math.pow(line3y,2);
        //Power them by 2.

        double line1 = Math.sqrt(line1x2 + line1y2);
        double line2 = Math.sqrt(line2x2 + line2y2);
        double line3 = Math.sqrt(line3x2 + line3y2);
        //Calculate the square root of them, and you get the length of line.

        double add = line1 + line2 + line3;
        double s = add / 2;
        double sLine1 = s - line1;
        double sLine2 = s - line2;
        double sLine3 = s - line3;
        double total = s * sLine1 * sLine2 * sLine3;
        double area = Math.sqrt(total);
        //Finally get the final result.

        System.out.println("The area of the triangle is " + area);
        //Print the result.

    }

}
