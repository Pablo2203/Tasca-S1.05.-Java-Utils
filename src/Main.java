import level1.exercise1.ArgumentValidator;
import level1.exercise2.ListDirectoryAlphabetically;
import level1.exercise3.SaveResult;
import level1.exercise4.FileReaderUtility;
import level1.exercise5.DeserializeObject;
import level1.exercise5.JavaObject;
import level1.exercise5.SerializeObject;
import level2.AppConfiguration;
import level3.FileDecrypter;
import level3.FileEncrypter;

public class Main {
    public static void main(String[] args) {
        //EX1
        if (!ArgumentValidator.validate(args)) {
            return;
        }

        String directoryPath = args[0];
        System.out.println("Listing directory contents: " + directoryPath);

        //EX2
        ListDirectoryAlphabetically.listDirectoryTree(directoryPath);

        //EX3
        SaveResult saveResult = new SaveResult();
        saveResult.listAndSaveDirectory(directoryPath, 1);
        System.out.println("\nContent saved to the file Path.txt:");
        saveResult.readFilePath();

        //EX4
        try {
            FileReaderUtility.processFile(args);
        } catch (Exception e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }


        //EX5
        String inputPath = "src/main/resources/Path.txt";
        JavaObject javaObject = new JavaObject(inputPath, 1);
        String serializedFilePath = "src/main/resources/JavaObject.txt";
        SerializeObject.serializeObject(javaObject, serializedFilePath);

        JavaObject deserializedObject = DeserializeObject.deserializeObject(serializedFilePath);
        if (deserializedObject != null) {
            System.out.println("\nContent retrieved from the file JavaObject.txt:");
            System.out.println("Path: " + deserializedObject.getPath());
        } else {
            System.out.println("The object could not be retrieved from the file.");
        }

        //LVL2
        AppConfiguration configuration = new AppConfiguration();
        String directory = configuration.getProperty("directory.read");
        String file = configuration.getProperty("file.output");

        System.out.println("Read directory: " + directory);
        System.out.println("Output file: " + file);

        //LVL3
        try {
            FileEncrypter.encrypt(inputPath);

            String encryptedFilePath = inputPath + ".enc";
            FileDecrypter.decrypt(encryptedFilePath);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}