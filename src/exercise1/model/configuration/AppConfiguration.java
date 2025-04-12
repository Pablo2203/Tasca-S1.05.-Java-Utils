package exercise1.model.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfiguration {

    private Properties properties = new Properties();

    public AppConfiguration() {
        String propertiesFilePath = "src/main/resources/testFile.properties";

        try (InputStream fis = new FileInputStream(propertiesFilePath)) {
            properties.load(fis);

            String directoryRead = properties.getProperty("directory.read");
            String fileOutput = properties.getProperty("file.output");

            if (directoryRead == null || fileOutput == null) {
                throw new IOException("Missing required properties.");
            }

            System.out.println("Directory: " + directoryRead);
            System.out.println("Output file: " + fileOutput);

        } catch (IOException e) {
            System.err.println("Error during file loading: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
