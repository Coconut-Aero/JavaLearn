import java.util.*;
public class srpgwin2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Create a scanner
        int win = 0;
        while(win<2) {
            System.out.print("Scissor(0) , Rock (1) , Paper (2) :");
            int player = input.nextInt();
            int computer = (int) (Math.random() * 3);
            switch (computer) {
                case 0:
                    System.out.print("The computer is scissor.");
                    break;
                case 1:
                    System.out.print("The computer is rock.");
                    break;
                case 2:
                    System.out.print("The computer is paper.");
                    break;
            }
            switch (player) {
                case 0:
                    System.out.print("You are scissor.");
                    break;
                case 1:
                    System.out.print("You are rock.");
                    break;
                case 2:
                    System.out.print("You are paper.");
                    break;
            }

            if(player!=0&&player!=1&&player!=2){
                System.out.println("You entered an invalid number.");
            }
            //Cheating is banned.

            else if (player < computer) {
                if ((player != 0) || (computer != 2)) {
                    System.out.println("Computer Wins.");
                }
                else {
                    System.out.println("You win.");
                    win++;
                }
            }
            else if (player != computer) {
                if ((player != 2) || (computer != 0)) {
                    System.out.println("You win.");
                    win++;
                }
                else {
                    System.out.println("Computer wins.");
                }
            }
            else {
                System.out.println("This round tied.");
            }
        }
    }
}
