import java.util.*;
public class hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean again = false;
        while (!again) {
            String[] words = {"write", "program", "that", "analysis", "culture", "access"};
            int choice = (int) (Math.random() * 6);
            int miss = 0;
            String chosenword = words[choice];
            String[] chosenw = chosenword.split("");
            boolean[] guess = new boolean[chosenword.length()];
            boolean exit = false;
            while (!exit) {
                System.out.print("(Guess) Enter a letter in word ");
                for (int i = 0; i < chosenword.length(); i++) {
                    if (!guess[i]) {
                        System.out.print("*");
                    } else {
                        System.out.print(chosenw[i]);
                    }
                }
                System.out.print(" >");
                char enter1 = input.next().charAt(0);
                String enter = "" + enter1;
                int notin = 0;
                for (int i = 0; i < chosenword.length(); i++) {
                    if (Objects.equals(enter, chosenw[i]) && !guess[i]) {
                        guess[i] = true;
                    } else if (Objects.equals(enter, chosenw[i])) {
                        System.out.println(enter + "  is already in the word");
                        break;
                    } else {
                        notin++;
                    }
                }
                if(notin == chosenword.length()){
                    System.out.println(enter + "  is not in the word");
                    miss++;
                }
                int exit1 = 0;
                for (int i = 0; i < chosenword.length(); i++) {
                    if (guess[i]) {
                        exit1++;
                    } else {
                        break;
                    }
                }
                if (exit1 == chosenword.length()) {
                    exit = true;
                }
            }
            System.out.println("The word is " + chosenword + ". You missed " + miss + " time(s).");
            System.out.print("Do you want to guess another time? (Y/N)>");
            String request = input.next();
            again= !request.equals("Y") && !request.equals("y");
        }
    }
}
