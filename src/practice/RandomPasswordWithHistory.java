package practice;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class RandomPasswordWithHistory {
    public static void main(String[] args) throws Exception {
        String[][] Password;
        Date date = new Date();
        Scanner sc = new Scanner(System.in);
        File Target = new File("PasswordHistory");
        System.out.println("Working directory is :" + new File("").getAbsolutePath());
        System.out.println("History file directory is : " + Target.getAbsolutePath());
        if (!Target.exists()) {
            System.out.println("History file is not exist, I will create it." );
            boolean newFile = Target.createNewFile();
            if (!newFile) {
                System.out.println("No permission to create new file.");
                System.exit(1);
            }
        }

        if (!Target.canWrite()) {
            System.out.println("History file is not writable");
            System.exit(1);
        }
        System.out.println("Local time is "+ date);
        System.out.print("Default format is:20 Passwords, 16 Digits. With or Without special format?(Y/N)");
        String cmd = sc.nextLine();
        if (!cmd.equals("Y")&&!cmd.equals("N")&&!cmd.equals("y")&&!cmd.equals("n")) {
            throw new Exception("RandomPasswordWithHistory.InvalidCommandError");
        }
        else if (cmd.equals("y")||cmd.equals("Y")) {
            System.out.print("How many Passwords do you want:");
            int num = sc.nextInt();
            System.out.print("Then what is the length of the password:");
            int length = sc.nextInt();
            Password = RandomPassword.GenerateRandomPasswordWithSpecialFormat(num, length);
        }
        else{
            Password = RandomPassword.GenerateRandomPassword();
        }
        try (
                FileWriter fw = new FileWriter(Target, true);
                PrintWriter output = new PrintWriter(fw)
        ) {
                output.println("Generate Time: " + date);
                output.println("Quantity = " + Password.length + " Length = " + Password[0].length);
                output.println("------------------------------");
                for (int i = 0; i < Password.length; i++) {
                    output.print( (i+1) + ". " );
                    for (int j = 0; j < Password[i].length; j++) {
                        String s1 = Password[i][j];
                        output.print(s1);
                    }
                    output.println();
                }
                output.println();
        }
    }
}
