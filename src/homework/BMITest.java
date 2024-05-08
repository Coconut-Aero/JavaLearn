package homework;

public class BMITest {
    public static void main(String[] args) {
        BMI bmi1= new BMI("Kim Yang",145,10,5,18);
        System.out.println("The BMI for " + bmi1.getName() + " is " + bmi1.getBMI() + " " + bmi1.getStatus());
        BMI bmi2 = new BMI("Susan King",215,10,5);
        System.out.println("The BMI for " + bmi2.getName() + " is " + bmi2.getBMI() + " " + bmi2.getStatus());
    }
}

class BMI{
    private String name;
    private double weight;
    private int age;
    private double inches;
    private double feet;
    private double height;
    public static final double KILOGRAMS_PER_POUND = 0.45359237;
    public static final double METERS_PER_INCH = 0.0254;
    public static final double METERS_PER_FEET = 1 / 3.28084;



    public BMI(String name, double weight, double inches, double feet, int age){
        this.name = name;
        this.weight = weight;
        this.height = feet * METERS_PER_FEET + inches * METERS_PER_INCH;
        this.age = age;
    }

    public BMI(String name, double weight, double inches, double feet){
        this (name, weight, inches, feet , 20);
    }

    public double getBMI(){
        double bmi= weight * KILOGRAMS_PER_POUND /( height * height );
        return Math.round(bmi*100)/100.0;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public double getHeight(){
        return height;
    }

    public int getAge(){
        return age;
    }

    public String getStatus(){
        double bmi = getBMI();
        if(bmi < 18.5){
            return "Underweight";
        }
        else if(bmi < 25.0){
            return "Normal";
        }
        else if(bmi < 29.5){
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }
}

