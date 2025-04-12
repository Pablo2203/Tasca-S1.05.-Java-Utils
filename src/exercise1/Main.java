package exercise1;

import exercise1.model.*;
import exercise1.model.configuration.AppConfiguration;
import exercise1.model.serialization.DeserializeObject;
import exercise1.model.serialization.SerializeObject;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        if (args.length < 1) {
            System.out.println("Please provide the path as an argument.");
            return;
        }

        String directoryPath = args[0];
        System.out.println("Listing directory contents: " + directoryPath);

        ListDirectoryAlphabetically.listDirectoryTree(directoryPath);

        SaveResult saveResult = new SaveResult();
        saveResult.listAndSaveDirectory(directoryPath, 1);
        System.out.println("\nContent saved to the file Path.txt:");
        saveResult.readFilePath();

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

        AppConfiguration configuration = new AppConfiguration();
        String directory = configuration.getProperty("directory.read");
        String file = configuration.getProperty("file.output");

        System.out.println("Read directory: " + directory);
        System.out.println("Output file: " + file);

        try {
            exercise1.model.fileEncrypterDecrypter.FileEncrypter.encrypt(inputPath);

            String encryptedFilePath = inputPath + ".enc";
            exercise1.model.fileEncrypterDecrypter.FileDecrypter.decrypt(encryptedFilePath);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}