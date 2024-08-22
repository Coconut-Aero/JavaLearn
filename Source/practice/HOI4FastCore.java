package practice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HOI4FastCore {
    public static void main(String[] args) throws IOException {
        File targetFile = new File("E:/all_core.txt");

        System.out.println("Target file directory is : "+targetFile.getAbsolutePath());

        if (!targetFile.exists()) {
            System.out.println("History file does not exist. Creating a new file.");
            boolean newFile = targetFile.createNewFile();
            if (!newFile) {
                System.out.println("History file could not be created. Working directory may not have the permission.");
            }
        }

        if (!targetFile.canWrite()) {
            System.out.println("Target file is not writable");
            System.exit(1);
        }

        try (
                // Create input and output files
                PrintWriter output = new PrintWriter(targetFile)
        ) {
            for (int i = 0; i < 30000; i++) {
                String s1 = "add_core";
                String s2 = String.valueOf(i);
                String s3 = s1 + " " + s2;
                output.println(s3);
            }
        }
    }
}
