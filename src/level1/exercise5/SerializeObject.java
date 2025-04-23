package level1.exercise5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeObject {

    public static void serializeObject(Serializable object, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
            System.out.println("Object successfully serialized to: " + file);
        } catch (IOException e) {
            System.err.println("Error while serializing the object: " + e.getMessage());
        }
    }
}