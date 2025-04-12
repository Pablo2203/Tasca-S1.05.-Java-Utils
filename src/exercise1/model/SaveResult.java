package exercise1.model;
import java.io.*;

public class SaveResult {

    private static final String FILE_NAME = "src/main/resources/Path.txt";

    public void savePath(String directory, int level) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Directory: " + directory + " | Level: " + level);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving to Path.txt: " + e.getMessage());
        }
    }

    public void readFilePath() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Contents of Path.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading Path.txt: " + e.getMessage());
        }
    }

    public void listAndSaveDirectory(String directoryPath, int level) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("The provided path is not valid: " + directoryPath);
            return;
        }

        File[] contents = directory.listFiles();

        if (contents != null) {
            for (File file : contents) {
                savePath(file.getAbsolutePath(), level);
                for (int i = 0; i < level; i++) {
                    System.out.print("    ");
                }
                System.out.println("Directory/File: " + file.getAbsolutePath() + " | Level: " + level);

                if (file.isDirectory()) {
                    listAndSaveDirectory(file.getAbsolutePath(), level + 1);
                }
            }
        } else {
            System.err.println("Could not read the contents of the directory: " + directoryPath);
        }
    }
}