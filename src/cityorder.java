import java.util.*;
public class cityorder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Create a new scanner
        System.out.print("Enter the first city ");
        String city1= input.next();
        System.out.println();
        System.out.print("Enter the second city ");
        String city2= input.next();
        System.out.println();
        System.out.print("Enter the third city ");
        String city3= input.next();
        System.out.println();

        String Biggest;
        String Smallest;
        String Middle;
        int compare1 = city1.compareTo(city2);
        int compare2 = city2.compareTo(city3);
        int compare3 = city1.compareTo(city3);
        if (compare1==0&&compare2==0&&compare3==0){
            Biggest = city3;
            Middle = city2;
            Smallest = city1;
        }
        else if (compare1==0) {
            if(compare2>0){
                Biggest = city1;
                Middle = city2;
                Smallest = city3;
            }
            else{
                Biggest = city3;
                Middle = city1;
                Smallest = city2;
            }
        }
        else if (compare2==0) {
            if(compare3>0){
                Biggest = city1;
                Middle = city3;
                Smallest = city2;
            }
            else{
                Biggest = city2;
                Middle = city3;
                Smallest = city1;
            }
        }
        else if (compare3==0) {
            if(compare1>0){
                Biggest = city1;
                Middle = city3;
                Smallest = city2;
            }
            else{
                Biggest = city2;
                Middle = city1;
                Smallest = city3;
            }
        }
        else if (compare1<0&&compare2<0){
            Biggest = city3;
            Middle = city2;
            Smallest = city1;
        }
        else if (compare1>0&&compare2>0){
            Biggest = city1;
            Middle = city2;
            Smallest = city3;
        }
        else if (compare1<0){
            Biggest = city2;
            if (compare3>0){
                Middle = city1;
                Smallest = city3;
            }
            else {
                Middle = city3;
                Smallest = city1;
            }
        }
        else{
            if (compare3>0){
                Biggest = city1;
                Middle = city3;
            }
            else {
                Biggest = city3;
                Middle = city1;
            }
            Smallest = city2;
        }
        System.out.println("The three cities in alphabetical order are "+ Smallest + " " + Middle + " " + Biggest);
    }
}
