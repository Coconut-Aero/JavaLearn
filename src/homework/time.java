package homework;

import java.util.Objects;

public class Time
{
    public static void main(String[] args) throws Exception
    {
        Time time = new Time();
        System.out.println(time.TimeStampToTime());
        System.out.println(time.TimeStampToTimeByZone(8,"+"));
        System.out.println(time.TimeStampToTimeByZone(1,"+"));
        System.out.println(time.TimeStampToTimeByZone(5,"-"));
    }
    static long totalSecond;
    static long totalMinute;
    static long totalHour;
    static long totalDay;
    static long currentSecond;
    static long currentMinute;
    static long currentHour;
    static long StartDayInMonth = 31;
    static long totalMonth;
    static long currentDay;
    static long currentMonth;
    static long currentYear;
    static int month = 1;
    static int year=1970;
    static String[][] timeZone = {
            {"-", "12", "Baker Island (BIT)"},
            {"-", "11", "American Samoa (SST)"},
            {"-", "10", "Hawaii (HST), Tahiti (TAHT)"},
            {"-", "9", "Alaska (AKST)"},
            {"-", "8", "Pacific Standard Time (PST), Vancouver (PST)"},
            {"-", "7", "Mountain Standard Time (MST)"},
            {"-", "6", "Central Standard Time (CST), Mexico City (CST)"},
            {"-", "5", "Eastern Standard Time (EST), Colombia (COT)"},
            {"-", "4", "Atlantic Standard Time (AST), Venezuela (VET), Puerto Rico (AST)"},
            {"-", "3", "Brazil (BRT), Argentina (ART)"},
            {"-", "2", "South Georgia (GST)"},
            {"-", "1", "Azores (AZOT), Cape Verde (CVT)"},
            {"+", "0", "Greenwich Mean Time (GMT), Iceland (GMT), Portugal (WET)"},
            {"+", "1", "Central European Time (CET), Germany (CET), France (CET), British Summer Time (BST)"},
            {"+", "2", "Eastern European Time (EET), Israel (IST), Greece (EET)"},
            {"+", "3", "Moscow Standard Time (MSK), Turkey (TRT), Saudi Arabia (AST)"},
            {"+", "4", "Gulf Standard Time (GST), Azerbaijan (AZT), United Arab Emirates (UAE)"},
            {"+", "5", "Pakistan Standard Time (PKT), Uzbekistan (UZT)"},
            {"+", "6", "Bangladesh Standard Time (BST), Kazakhstan (ALMT)"},
            {"+", "7", "Indochina Time (ICT), Thailand (ICT), Vietnam (ICT)"},
            {"+", "8", "China Standard Time (CST), Singapore (SGT), Malaysia (MYT), Australia Western Standard Time (AWST)"},
            {"+", "9", "Japan Standard Time (JST), Korea Standard Time (KST)"},
            {"+", "10", "Australian Eastern Standard Time (AEST), Guam (ChST)"},
            {"+", "11", "Solomon Islands (SBT), New Caledonia (NCT)"},
            {"+", "12", "New Zealand Standard Time (NZST), Fiji (FJT)"},
            {"+", "13", "Tonga Time (TOT), Samoa (WST)"}
    };




    public Time(){
        totalSecond = System.currentTimeMillis() / 1000;
        totalMinute = totalSecond / 60;
        totalHour = totalMinute / 60;
        totalDay = totalHour / 24;
        currentSecond = totalSecond % 60;
        currentMinute = totalMinute % 60;
        currentHour = totalHour % 24;
        StartDayInMonth = 31;
        while(totalDay >= StartDayInMonth){
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    totalDay -= 31;
                    month++;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    totalDay -= 30;
                    month++;
                    break;
                case 2:
                    if((year%4==0&&year%100!=0)||(year%400==0)){
                        totalDay -= 29;
                    } else{
                        totalDay -= 28;
                    }
                    month++;
                    break;
            }
            if(month==13){
                month=1;
                year++;
            }
        }
        totalMonth = month;
        currentDay = totalDay + 1;
        currentMonth = totalMonth % 12;
        currentYear = year;
    }

    public Time(long timeMills){
        totalSecond = timeMills / 1000;
        totalMinute = totalSecond / 60;
        totalHour = totalMinute / 60;
        totalDay = totalHour / 24;
        currentSecond = totalSecond % 60;
        currentMinute = totalMinute % 60;
        currentHour = totalHour % 24;
        StartDayInMonth = 31;
        while(totalDay >= StartDayInMonth){
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    totalDay -= 31;
                    month++;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    totalDay -= 30;
                    month++;
                    break;
                case 2:
                    if((year%4==0&&year%100!=0)||(year%400==0)){
                        totalDay -= 29;
                    } else{
                        totalDay -= 28;
                    }
                    month++;
                    break;
            }
            if(month==13){
                month=1;
                year++;
            }
        }
        totalMonth = month;
        currentDay = totalDay + 1;
        currentMonth = totalMonth % 12;
        currentYear = year;
    }

    public String TimeStampToTime () {
        return String.format("%d-%02d-%02d %02d:%02d:%02d UTC", currentYear, currentMonth,  currentDay,  currentHour,  currentMinute,  currentSecond);
    }


    public String TimeStampToTimeByZone(int ZoneNum, String PN) throws Exception {
        long[] ChangedZone = TimeZone(ZoneNum, PN);
        String ZoneName;
        if(Objects.equals(PN, "+")){
            ZoneName=timeZone[12+ZoneNum][2];
        }else {
            ZoneName=timeZone[12-ZoneNum][2];
        }

        return String.format("%d-%02d-%02d %02d:%02d:%02d UTC%s%d %s",
                ChangedZone[0], ChangedZone[1], ChangedZone[2], ChangedZone[3], currentMinute, currentSecond, PN, ZoneNum, ZoneName);
    }
    public static boolean OutDayInMonth(){
        return (
                ((currentDay + 1 < 32) && (currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7
                        || currentMonth == 8 || currentMonth == 10 || currentMonth == 12)) ||
                        ((currentDay + 1 < 31) && (currentMonth == 4 || currentMonth == 6 || currentMonth == 9 || currentMonth == 11))||
                        ((currentDay + 1 < 30) && (currentMonth == 2 ) && ((year%4==0&&year%100!=0)||(year%400==0)))||
                        ((currentDay + 1 < 29) && (currentMonth == 2 ) && !((year%4==0&&year%100!=0)||(year%400==0))));
    }
    public static long[] TimeZone (int ZoneNum, String PN) throws Exception {
        long[] ChangedZone = new long[4];
        /*
            ChangedZone[0] = Year
            ChangedZone[1] = Month
            ChangedZone[2] = Day
            ChangedZone[3] = Hour
        */
        if (Objects.equals(PN, "+")) {
            if (currentHour + ZoneNum < 24) {
                ChangedZone[0] = currentYear;
                ChangedZone[1] = currentMonth;
                ChangedZone[2] = currentDay;
                ChangedZone[3] = currentHour + ZoneNum;
            } else if ((currentHour + ZoneNum >= 24) && OutDayInMonth()) {
                ChangedZone[3] = currentHour + ZoneNum - 24;
                ChangedZone[2] = currentDay + 1;
                ChangedZone[0] = currentYear;
                ChangedZone[1] = currentMonth;
            } else if ((currentHour + ZoneNum >= 24) && !OutDayInMonth()) {
                if (month == 12) {
                    ChangedZone[0] = currentYear + 1;
                    ChangedZone[1]  = 1;
                } else {
                    ChangedZone[1] = currentMonth + 1;
                }
                ChangedZone[2] = 1;
                ChangedZone[3] = currentHour + ZoneNum - 24;
            }
        } else if (Objects.equals(PN, "-")) {
            if (currentHour + ZoneNum >= 0) {
                ChangedZone[0] = currentYear;
                ChangedZone[1] = currentMonth;
                ChangedZone[2] = currentDay;
                ChangedZone[3] = currentHour - ZoneNum;
            } else if ((currentHour + ZoneNum < 0) && currentDay != 1) {
                ChangedZone[0] = currentYear;
                ChangedZone[1] = currentMonth;
                ChangedZone[2] = currentDay - 1;
                ChangedZone[3] = currentHour - ZoneNum + 24;
            } else if ((currentHour + ZoneNum < 0) && currentDay == 1) {
                ChangedZone[3] = currentHour - ZoneNum + 24;
                if (currentMonth == 5 || currentMonth == 7 || currentMonth == 10 || currentMonth == 12) {
                    ChangedZone[1] = currentMonth - 1;
                    ChangedZone[2] = 30;
                } else if (currentMonth == 2 || currentMonth == 4 || currentMonth == 6 || currentMonth == 8 || currentMonth == 9 || currentMonth == 11) {
                    ChangedZone[1] = currentMonth - 1;
                    ChangedZone[2] = 31;
                } else if (currentMonth == 3) {
                    ChangedZone[1] = currentMonth - 1;
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        ChangedZone[2] = 29;
                    } else ChangedZone[2] = 28;
                } else {
                    ChangedZone[1]  = 12;
                    ChangedZone[2] = 31;
                    ChangedZone[0] = currentYear - 1;
                }
            }
        } else throw new Exception("time.InvalidCommandError");
        return ChangedZone;
    }
}
