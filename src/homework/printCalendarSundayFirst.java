package homework;

public class printCalendarSundayFirst{
    public static void printCalendarSunFirst(int year, int month) {
        printMonthTitleSundayFirst(year, month);
        printMonthBodySundayFirst(year, month);
    }

    public static void printMonthTitleSundayFirst(int year, int month) {
        System.out.println("         " + sharingMethods.getMonthName(month)
                + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
    }


    /** Print month body */
    public static void printMonthBodySundayFirst(int year, int month) {
        // Get start day of the week for the first date in the month
        int startDay = sharingMethods.getStartDay(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = sharingMethods.getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        int i;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay ) % 7 == 0)
                System.out.println();
        }

        System.out.println();
    }

}