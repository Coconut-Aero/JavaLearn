package practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StatisticRepoFiles {

    private static final Logger logger = LoggerFactory.getLogger(StatisticRepoFiles.class);

    public static void main(String[] args) {
        String directoryPath = "src";
        String fileExtension = ".java";
        int line = 0;
        long character = 0;
        int word = 0;
        String[] filePaths = findFilePaths(new File(directoryPath), fileExtension);

        System.out.println("Working directory is: " + new File(directoryPath).getAbsolutePath());
        System.out.println("The number of *.java files in the directory is: " + filePaths.length);

        for (String filePath : filePaths) {
            try (Scanner scanner = new Scanner(new File(filePath), StandardCharsets.UTF_8)) {
                while (scanner.hasNextLine()) {
                    String lineText = scanner.nextLine();
                    line++;
                    character += lineText.length();
                    String[] wordsInLine = lineText.split("\\s+");
                    word += wordsInLine.length;
                }
            } catch (IOException e) {
                logger.error("Error reading file: {}", filePath, e);
            }
        }

        System.out.println(character + " characters ");
        System.out.println(word + " words ");
        System.out.println(line + " lines ");
    }

    public static String[] findFilePaths(File directory, String fileExtension) {
        List<String> filePathList = new ArrayList<>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    String[] subDirFiles = findFilePaths(file, fileExtension);
                    filePathList.addAll(Arrays.asList(subDirFiles));
                } else if (file.getName().endsWith(fileExtension)) {
                    filePathList.add(file.getAbsolutePath());
                }
            }
        }
        return filePathList.toArray(new String[0]);
    }
}
