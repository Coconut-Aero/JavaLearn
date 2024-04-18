import java.util.Scanner;

public class galtonBoard {
    public static boolean BooleanRandom(){
        int ran = enhancedRandom.getRandom(-1,2,-1,2);
        return ran != 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop: ");
        int numBall = input.nextInt();
        System.out.print("Enter the number of slots in the machine: ");
        int numSlots = input.nextInt();
        int numPath = numSlots - 1;
        int[] numSlotBall = new int[numSlots];
        boolean[] numPathBall = new boolean[numPath];
        int ballWhere=0;
        for (int i = 0; i < numBall; i++) {
            for (int j = 0; j < numPath; j++) {
                numPathBall[j] = BooleanRandom();
                if (numPathBall[j]) {
                    System.out.print("L");
                }else {
                    System.out.print("R");
                    ballWhere++;
                }
            }
            numSlotBall[ballWhere-1]++;
            ballWhere=0;
            System.out.println();
        }
        for (int i = 0; i < numSlotBall.length; i++) {
            if(numSlotBall[i] != 0){
                System.out.println("Slot " + i + " have " + numSlotBall[i]);
            }
        }
    }
}
