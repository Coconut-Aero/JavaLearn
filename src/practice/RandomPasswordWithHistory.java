package practice;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class RandomPasswordWithHistory {
    public static void main(String[] args) throws Exception {
        String[][] Password ;
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

        System.out.print("Information Recording?(Y/N)");
        String cmd1 = sc.nextLine();
        String info = "";
        boolean InfoRecording = false;
        if (cmd1.equals("Y")|| cmd1.equals("y")){
            System.out.print("Enter your information: ");
            info = sc.nextLine();
            InfoRecording = true;
        }
        else if (!cmd1.equals("N")&&!cmd1.equals("n")){
            throw new Exception("RandomPasswordWithHistory.InvalidCommandError");
        }

        String cmd2;
        if (InfoRecording) {
            cmd2 = "Y";
        }
        else {
            System.out.print("Secure Mode?(Y/N)");
            cmd2 = sc.nextLine();
        }
        if (cmd2.equals("Y")|| cmd2.equals("y")) {
            String cmd3;
            if (!InfoRecording) {
                System.out.print("Default format is:20 Passwords, 16 Digits. With or Without special format?(Y/N)");
                cmd3 = sc.nextLine();
            }
            else cmd3 = "y";
            if (!cmd3.equals("Y")&&!cmd3.equals("N")&&!cmd3.equals("y")&&!cmd3.equals("n")) {
                throw new Exception("RandomPasswordWithHistory.InvalidCommandError");
            }
            else if (cmd3.equals("y")|| cmd3.equals("Y")) {
                int num;
                int length;
                if (!InfoRecording) {
                    System.out.print("How many Passwords do you want:");
                    num = sc.nextInt();
                    System.out.print("Then what is the length of the password:");
                }
                else{
                    num = 1;
                    System.out.print("What is the length of the password:");
                }
                length = sc.nextInt();
                Password = RandomPassword.GenerateSecureRandomPasswordWithSpecialFormat(num, length);
            }
            else{
                Password = RandomPassword.GenerateSecureRandomPassword();
            }
        }
        else if (cmd2.equals("N")|| cmd2.equals("n")) {
            System.out.print("Default format is:20 Passwords, 16 Digits. With or Without special format?(Y/N)");
            String cmd3 = sc.nextLine();
            if (!cmd3.equals("Y")&&!cmd3.equals("N")&&!cmd3.equals("y")&&!cmd3.equals("n")) {
                throw new Exception("RandomPasswordWithHistory.InvalidCommandError");
            }
            else if (cmd3.equals("y")|| cmd3.equals("Y")) {
                System.out.print("How many Passwords do you want:");
                int num = sc.nextInt();
                System.out.print("Then what is the length of the password:");
                int length = sc.nextInt();
                Password = RandomPassword.GenerateRandomPasswordWithSpecialFormat(num, length);
            }
            else{
                Password = RandomPassword.GenerateRandomPassword();
            }
        }
        else {
            throw new Exception("RandomPasswordWithHistory.InvalidCommandError");
        }

        try (
                FileWriter fw = new FileWriter(Target, true);
                PrintWriter output = new PrintWriter(fw)
        ) {
            output.println("Generate Time: " + date);
            if (Password != null) {
                output.println("Quantity = " + Password.length + " Length = " + Password[0].length);
            }
            output.print("Secure Mode");
            if (cmd2.equals("Y")|| cmd2.equals("y")) {
                output.println(" On");
            }
            else{
                output.println(" Off");
            }
            output.print("Information Recording");
            if (InfoRecording) {
                output.println(" On : " + info);
            }
            else output.println(" Off");
            output.println("------------------------------");
            if (Password != null) {
                for (int i = 0; i < Password.length; i++) {
                    output.print( (i+1) + ". " );
                    for (int j = 0; j < Password[i].length; j++) {
                        String s1 = Password[i][j];
                        output.print(s1);
                    }
                    output.println();
                }
            }
            output.println();
        }
        System.out.println("Password History has been saved.");
    }
}

