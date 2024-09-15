package homework;

public class printCalendarMondayFirst {
    public static void printCalendarMonFirst(int year, int month) {
        printMonthTitleMondayFirst(year, month);
        printMonthBodyMondayFirst(year, month);
    }

    /** Print the month title, e.g., May, 1999 */
    public static void printMonthTitleMondayFirst(int year, int month) {
        System.out.println("         " + sharingMethods.getMonthName(month)
                + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun ");
    }

    /** Print month body */
    public static void printMonthBodyMondayFirst(int year, int month) {
        // Get start day of the week for the first date in the month
        int startDay = sharingMethods.getStartDay(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = sharingMethods.getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        int i;
        for (i = 0; i < startDay - 1; i++)
            System.out.print("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay - 1) % 7 == 0)
                System.out.println();
        }

        System.out.println();
    }
}