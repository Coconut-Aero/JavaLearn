package homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileStatistics {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println(
                    "Usage: java FileStatistics <filename>");
            System.exit(1);
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("Target file " + args[0] + " not exists");
            System.exit(2);
        }
        Scanner input = new Scanner(file);
        long character = 0;
        int word = 0;
        int line = 0;
        while (input.hasNextLine()) {
            String lineText = input.nextLine();
            line++;
            character += lineText.length();
            Scanner lineScanner = new Scanner(lineText);
            while (lineScanner.hasNext()) {
                word++;
                lineScanner.next();
            }
            lineScanner.close();
        }
        input.close();
        System.out.println("Last Modified Time " + time.TimeStampToTime(file.lastModified()));
        System.out.println(character + " characters ");
        System.out.println(word + " words ");
        System.out.println(line + " lines ");
    }
}
