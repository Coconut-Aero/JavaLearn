import java.util.Scanner;

public class repeatedInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of integers:");
        int length = input.nextInt();
        int[] nums = new int[length];
        boolean[] read = new boolean[length];
        System.out.print("Enter the integers between 1~100:");
        for (int i = 0; i < length; i++) {
            nums[i]=input.nextInt();
        }

        for (int i = 0; i < nums.length; i++) {
            if (read[i]) {
                continue;
            }
            read[i]=true;
            int tmp = nums[i];
            int time = 0;
            int[] sortedNums = sorted.Sort(nums);
            for (int j = i; j < sortedNums.length; j++) {
                if (tmp == sortedNums[j]) {
                    read[j] = true;
                    time++;
                }
            }
            if (time == 0) {
                System.out.println("No repeated integer");
            }else if (time == 1){
                System.out.println(sortedNums[i] + " occurs " + time + " time");
            }else {
                System.out.println(sortedNums[i] + " occurs " + time + " time");
            }
        }
    }
}

