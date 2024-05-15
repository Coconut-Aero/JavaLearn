package homework;

import java.util.Arrays;

public class calcEnhanced {
    public static void main(String[] args) {
        String str1 = String.join("", Arrays.copyOfRange(args, 0, args.length));
        int check = check(args);
        String[] tokens;
        if (check == 1) tokens = str1.split(" ");
        else tokens = str1.split("");
        switch (tokens[1]){
            case "+":
                System.out.println(Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]));
                break;
            case "-":
                System.out.println(Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]));
                break;
            case "*":
                System.out.println(Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]));
                break;
            case "/":
                System.out.println(Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]));
                break;
            default:
                System.out.println("Invalid input");
        }
    }
    public static int check(String[] args) {
        for (String arg : args) {
            if (arg.equals(" ")) {
                return 1;
            }
        }
        return 0;
    }
}
