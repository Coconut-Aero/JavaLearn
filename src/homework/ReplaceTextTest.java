package homework;

import java.io.*;
import java.util.Scanner;

public class ReplaceTextTest {
    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
        if (args.length != 3) {
            System.out.println(
                    "Usage: java ReplaceTextTest targetFile oldStr newStr");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File("D://temp.txt");

        // Check if target file exists
        File targetFile = new File(args[0]);
        if (!targetFile.exists()) {
            System.out.println("Target file " + args[1] + " not exists");
            System.exit(2);
        }

        try (
                // Create input and output files
                Scanner input = new Scanner(targetFile);
                PrintWriter output = new PrintWriter(sourceFile)
        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[1], args[2]);
                output.println(s2);
            }
            input.close();
            output.close();
            if (targetFile.delete()) {
                System.out.println("Deleted old file.");
            } else {
                System.out.println("Failed to delete old file.");
                System.exit(3);
            }
            File newTargetFile = new File(args[0]);
            if (sourceFile.renameTo(newTargetFile)) {
                System.out.println("Renamed file.");
            } else {
                System.out.println("Failed to rename new file.");
                System.exit(4);
            }
        }
    }
}

