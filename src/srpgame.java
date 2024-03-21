import java.util.*;
public class srpgame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Create a scanner
        boolean exit = false;
        while(!exit) {
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
                }
            }
            else if (player != computer) {
                if ((player != 2) || (computer != 0)) {
                    System.out.println("You win.");
                }
                else {
                    System.out.println("Computer wins.");
                }
            }
            else {
                System.out.println("This round tied.");
            }
            System.out.print("Play again?(Y/N)");
            String request = input.next();
            exit= !request.equals("Y") && !request.equals("y");
        }
    }
}
