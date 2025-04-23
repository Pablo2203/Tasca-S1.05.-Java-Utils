package level1.exercise4;

import java.io.File;

public class FileReaderUtility {

    public static void processFile(String[] args) {
        String filePath = getFilePath(args);

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("The file does not exist or is invalid: " + filePath);
        }

        readAndPrintFile(filePath);
    }

    private static String getFilePath(String[] args) {
        if (args.length > 0) {
            return args[0];
        }

        System.out.println("No file path provided. Using default path...");
        return "src/main/resources/Path.txt";
    }

    public static void readAndPrintFile(String filePath) {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading the file: " + filePath, e);
        }
    }
}

