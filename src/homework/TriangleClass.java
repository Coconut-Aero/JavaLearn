package homework;

class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return "created on " + dateCreated + "\ncolor:" + color + "and filled:" + filled;
    }
}

class Triangle extends GeometricObject{
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;
    public Triangle(String color, boolean filled){
        super(color,filled);
    }
    public Triangle(String color, boolean filled,double side1, double side2, double side3){
        super(color,filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public void setSide(String cmd, double newLength){
        switch(cmd){
            case "side1": this.side1 = newLength;
            case "side2": this.side2 = newLength;
            case "side3": this.side3 = newLength;
        }
    }
    public double getSide(String cmd){
        return switch (cmd) {
            case "side1" -> this.side1;
            case "side2" -> this.side2;
            case "side3" -> this.side3;
            default -> 0;
        };
    }
    public static double getArea(double side1, double side2, double side3){
        double add = side1 + side2 + side3;
        double s = add / 2;
        double sLine1 = s - side1;
        double sLine2 = s - side2;
        double sLine3 = s - side3;
        double total = s * sLine1 * sLine2 * sLine3;
        return Math.sqrt(total);
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    public String toString(){
        return "Triangle "+ "Side 1 = " + side1 + ", Side 2 = " + side2 + ", Side 3 = " + side3;
    }
}

