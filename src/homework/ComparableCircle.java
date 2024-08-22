package homework;

import java.util.Scanner;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter the radius of the circle 1");
        double radius1 = sc.nextDouble();
        ComparableCircle circle1 = new ComparableCircle();
        circle1.setRadius(radius1);
        System.out.println("The circle's radius is " + circle1.getRadius());
        System.out.println();
        System.out.println("Please enter the radius of the circle 2");
        double radius2 = sc.nextDouble();
        ComparableCircle circle2 = new ComparableCircle();
        circle2.setRadius(radius2);
        System.out.println("The circle's radius is " + circle2.getRadius());
        System.out.println();
        if (circle1.compareTo(circle2) > 0) {
            System.out.println("The circle 1's area is greater than the circle 2's area");
        }
        else if (circle1.compareTo(circle2) < 0) {
            System.out.println("The circle 1's area is less than the Circle 2's area");
        }
        else {
            System.out.println("The circle 1's area is equal to the Circle 2's area");
        }
        System.out.println();
        System.out.println("Please enter the radius of the circle 3");
        double radius3 = sc.nextDouble();
        ComparableCircle circle3 = new ComparableCircle();
        circle3.setRadius(radius3);
        System.out.println("The circle's radius is " + circle3.getRadius());
        System.out.println();
        System.out.println("Please enter the side length of the square");
        double sideLength1 = sc.nextDouble();
        double sideLength2 = sc.nextDouble();
        Square square1 = new Square();
        square1.setSideLength1(sideLength1);
        square1.setSideLength2(sideLength2);
        System.out.println("The square's side length is " + square1.getSideLength1() + " and " + square1.getSideLength2());
        System.out.println();
        if (circle3.compareTo(square1) > 0) {
            System.out.println("The circle 3's area is greater than the square's area");
        }
        else if (circle3.compareTo(square1) < 0) {
            System.out.println("The circle 3's area is less than the square's area");
        }
        else {
            System.out.println("The circle 3's area is equal to the square's area");
        }
    }


    @Override
    public int compareTo(ComparableCircle o) {
        return Double.compare(getArea(), o.getArea());
    }

    @Override
    public int compareTo(Square o) {
        return Double.compare(getArea(), o.getArea());
    }
}

abstract class Circle extends GeometricObject {
    private double radius;

    public Circle() {
        this(1.0); // Default radius if not specified
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled); // Assuming GeometricObject has this constructor
        this.radius = radius;
    }

    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    /** Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /** Print the circle info */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }

    public abstract int compareTo(Square o);
}

class Square extends GeometricObject {
    private double sideLength1;
    private double sideLength2;

    public Square() {
        this.sideLength1 = 1.0;
        this.sideLength2 = 1.0;
    }

    public Square(double sideLength1, double sideLength2) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    public double getSideLength1() {
        return sideLength1;
    }

    public void setSideLength1(double sideLength1) {
        this.sideLength1 = sideLength1;
    }

    public double getSideLength2() {
        return sideLength2;
    }

    public void setSideLength2(double sideLength2) {
        this.sideLength2 = sideLength2;
    }

    public double getArea() {
        return sideLength1 * sideLength2;
    }

    public double getPerimeter() {
         return sideLength1 * 2 + sideLength1 * 2;
    }
}


