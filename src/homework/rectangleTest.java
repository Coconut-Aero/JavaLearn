package homework;

public class rectangleTest {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4,40);
        Rectangle rectangle2 = new Rectangle(3.5,35.9);
        System.out.println("The area of " + "homework.Rectangle 1 is " + rectangle1.getArea());
        System.out.println("The area of " + "homework.Rectangle 2 is " + rectangle2.getArea());
        System.out.println("The perimeter of " + "homework.Rectangle 1 is " + rectangle1.getPerimeter());
        System.out.println("The perimeter of " + "homework.Rectangle 2 is " + rectangle2.getPerimeter());
    }
}
class Rectangle{
    double width;
    double height;
    Rectangle(double newWidth, double newHeight){
        width = newWidth;
        height = newHeight;
    }
    double getArea(){
        return width * height;
    }
    double getPerimeter(){
        return 2 * width + 2 * height;
    }
}