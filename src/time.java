public class time
{
    public static void main(String[] args)
    {
        long totalMiS = System.currentTimeMillis();
        long totalSEC = totalMiS / 1000;
        long totalMIN = totalSEC / 60;
        long totalHOU = totalMIN / 60;
        long totalDAY = totalHOU / 24;
        long curreSEC = totalSEC % 60;
        long curreMIN = totalMIN % 60;
        long curreHOU = totalHOU % 24;

        long dayinmonth = 31;
        int month = 1;
        int year=1970;
        while(totalDAY>=dayinmonth){
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    totalDAY -= 31;
                    month++;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    totalDAY -= 30;
                    month++;
                    break;
                case 2:
                    if((year%4==0&&year%100!=0)||(year%400==0)){
                        totalDAY -= 29;
                    }
                    else{
                        totalDAY -= 28;
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


        long curreDAY = totalDAY + 1;
        long curreMON = totalMON % 12;
        long curreYER = year;
        System.out.println("Current time is " + curreYER + " " + curreMON + " " + curreDAY + " " + curreHOU + ":" + curreMIN + ":" + curreSEC + " GMT");
    }
}
