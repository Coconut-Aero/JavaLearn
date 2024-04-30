import java.util.*;
public class daysInMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Create a scanner

        System.out.println("Please enter the month and the year.");
        System.out.print("Month:");
        int month = input.nextInt();
        System.out.print("Year:");
        int year = input.nextInt();

        if(month!=2){
            if(((month<=7)&&(month%2==1))||((month>7)&&(month%2==0))){
                System.out.println(year + "." + month + " has 31 days.");
            }
            else{
                System.out.println(year + "." + month + " has 30 days.");
            }
        }
        else{
            if((year%4==0&&year%100!=0)||(year%400==0)){
                System.out.println(year + "." + month + " has 29 days.");
            }
            else{
                System.out.println(year + "." + month + " has 28 days.");
            }
        }
    }
}

