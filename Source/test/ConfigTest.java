package test;

import java.io.File;
import java.util.Scanner;

public class ConfigTest {
    public static void main(String[] args) throws Exception {
        File configFile = new File("src/test/config.yml");

        System.out.println("Working directory is :" + new File(".").getAbsolutePath());
        System.out.println("Config file directory is : "+configFile.getAbsolutePath());

        if (!configFile.exists()) {
            System.out.println("Config file does not exist");
            System.exit(1);
        }
        if (!configFile.canRead()) {
            System.out.println("Config file is not readable");
            System.exit(2);
        }
        if (configFile.length() == 0) {
            System.out.println("Config file is empty");
            System.exit(3);
        }

        Scanner input = new Scanner(configFile);

        while (input.hasNextLine()) {
            String cmd = input.next();
            while (cmd != null) {
                switch (cmd) {
                    case "timestamp":
                        System.out.println(System.currentTimeMillis());
                        break;
                    case "TestText":
                        System.out.println("HELLO WORLD");
                        break;
                }
                if (input.hasNext()) {
                    cmd = input.next();
                }
                else {
                    System.exit(0);
                }
            }
        }
    }
}
