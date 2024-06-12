package homework;

public class NewPrintCalendar {
    public static void main(String[] args)  throws Exception {
        if (args.length != 3) {
            System.out.println(
                    "Usage: java NewPrintCalendar Month Year WhichDayFirst(1 for Monday First, 0 for Sunday First)");
            System.exit(1);
        }
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        if (month < 1 || month > 12 || year < 1970) {
            System.out.println("Illegal month/year");
            System.exit(2);
        }
        int whichDayFirst = Integer.parseInt(args[2]);
        switch (whichDayFirst) {
            case 1:
                printCalendarMondayFirst.printCalendarMonFirst(year, month);
                break;
            case 0:
                printCalendarSundayFirst.printCalendarSunFirst(year, month);
                break;
            default:
                System.out.println("Invalid Options");
                System.exit(3);
                break;
        }
    }
}

class printCalendarMondayFirst {
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

class printCalendarSundayFirst{
    public static void printCalendarSunFirst(int year, int month) {
        printMonthTitleSundayFirst(year, month);
        printMonthBodySundayFirst(year, month);
    }

    /** Print the month title, e.g., May, 1999 */
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

class sharingMethods{
    /** Get the start day of month/1/year */
    public static int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        // Get total number of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = sharingMethods.getTotalNumberOfDays(year, month);

        // Return the start day for month/1/year
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }
    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        // Get the total days from 1800 to 1/1/year
        for (int i = 1800; i < year; i++)
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;

        // Add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);

        return total;
    }

    /** Get the number of days in a month */
    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0; // If month is incorrect
    }
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    /** Get the English name for the month */
    public static String getMonthName(int month) {

        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
    }

}