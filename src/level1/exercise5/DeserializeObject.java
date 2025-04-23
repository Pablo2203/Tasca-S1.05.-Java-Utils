package level1.exercise5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeObject {
    public static JavaObject deserializeObject(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object object = ois.readObject();
            if (object instanceof JavaObject) {
                System.out.println("Object successfully deserialized from: " + file);
                return (JavaObject) object;
            } else {
                System.err.println("The object in the file is not of type JavaObject.");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while deserializing the object: " + e.getMessage());
            return null;
        }
    }
}