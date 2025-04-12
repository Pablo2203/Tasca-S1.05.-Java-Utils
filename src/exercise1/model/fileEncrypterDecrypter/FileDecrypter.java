package exercise1.model.fileEncrypterDecrypter;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDecrypter {


    public static void decrypt(String encryptedFilePath) throws Exception {
        if (encryptedFilePath == null || encryptedFilePath.isEmpty()) {
            throw new IllegalArgumentException("The encrypted file path cannot be null or empty.");
        }

        File encryptedFile = new File(encryptedFilePath);
        if (!encryptedFile.exists()) {
            throw new IOException("The encrypted file does not exist: " + encryptedFilePath);
        }

        String keyFilePath = encryptedFilePath + ".key";
        String ivFilePath = encryptedFilePath + ".iv";

        File keyFile = new File(keyFilePath);
        File ivFile = new File(ivFilePath);

        if (!keyFile.exists() || !ivFile.exists()) {
            throw new IOException("The key file or IV file is missing. Ensure files "
                    + keyFilePath + " and " + ivFilePath + " are present.");
        }

        byte[] key = readFileToBytes(keyFile);
        byte[] iv = readFileToBytes(ivFile);
        byte[] encryptedBytes = readFileToBytes(encryptedFile);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));

        System.out.println("Decrypting the file...");
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        String outputFilePath = encryptedFilePath.replace(".enc", ".dec");
        writeBytesToFile(outputFilePath, decryptedBytes);

        System.out.println("The file has been successfully decrypted: " + outputFilePath);
    }

    private static byte[] readFileToBytes(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("The file cannot be null.");
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        } catch (IOException e) {
            throw new IOException("Failed to read the file: " + file.getAbsolutePath(), e);
        }
    }

    private static void writeBytesToFile(String filePath, byte[] data) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("The file path cannot be null or empty.");
        }
        if (data == null) {
            throw new IllegalArgumentException("The data to be written cannot be null.");
        }

        File file = new File(filePath);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
        } catch (IOException e) {
            throw new IOException("Failed to write to the file: " + file.getAbsolutePath(), e);
        }
    }
}