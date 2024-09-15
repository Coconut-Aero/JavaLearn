package practice;

import homework.printCalendarSundayFirst;
import java.util.Scanner;

public class AllYearCalendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        for (int i = 1; i < 13; i++) {
            printCalendarSundayFirst.printCalendarSunFirst( year , i );
            System.out.println();
        }
    }
}
