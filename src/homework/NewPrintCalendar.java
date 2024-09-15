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