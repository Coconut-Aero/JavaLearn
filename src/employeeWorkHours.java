import java.util.Scanner;

public class employeeWorkHours {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] workHours = new int[8][7];
        int[][] workTotalHours = new int[8][2];
        for (int i = 0; i < 8; i++) {
            System.out.print("Enter work hours of Employee " + i + ":");
            for (int j = 0; j < 7; j++) {
                workHours[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                workTotalHours[i][1] += workHours[i][j];
            }
            workTotalHours[i][0] = i;
        }
        for (int i = 0; i < 7; i++) {
            if (workTotalHours[i+1][1] < workTotalHours[i][1]) {
                int temp1 = workTotalHours[i+1][0];
                int temp2 = workTotalHours[i+1][1];
                workTotalHours[i+1][0] = workTotalHours[i][0];
                workTotalHours[i+1][1] = workTotalHours[i][1];
                workTotalHours[i][0] = temp1;
                workTotalHours[i][1] = temp2;
                i=-1;
            }
        }
        for (int i = 0; i < 8; i++) {
            System.out.println("Employee " + workTotalHours[i][0] + " work hours of " + workTotalHours[i][1]);
        }
    }
}
