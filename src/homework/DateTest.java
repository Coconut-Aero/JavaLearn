package homework;

public class DateTest {

}
class Date{
    long year, month, day;
    public Date(){
        new Date(System.currentTimeMillis());
    }
    public Date(long year, long month, long day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Date(long TotalMillSecond){
        long TotalSecond = TotalMillSecond/1000;
        long TotalMinutes = TotalSecond / 60;
        long TotalHours = TotalMinutes / 60;
        long TotalDays = TotalHours / 24;
        long dayinmonth = 31;
        int month = 1;
        int year=1970;
        while(TotalDays>=dayinmonth){
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    TotalDays -= 31;
                    month++;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    TotalDays -= 30;
                    month++;
                    break;
                case 2:
                    if((year%4==0&&year%100!=0)||(year%400==0)){
                        TotalDays -= 29;
                    } else{
                        TotalDays -= 28;
                    }
                    month++;
                    break;
            }
            if(month==13){
                month=1;
                year++;
            }
        }
        long totalMON = month;
        this.day = TotalDays + 1;
        this.month = totalMON % 12;
        this.year = year;
    }
    public long getYear() {
        return year;
    }
    public void setYear(long year) {
        this.year = year;
    }
    public long getMonth() {
        return month;
    }
    public void setMonth(long month) {
        this.month = month;
    }
    public long getDay() {
        return day;
    }
    public void setDay(long day) {
        this.day = day;
    }
}
