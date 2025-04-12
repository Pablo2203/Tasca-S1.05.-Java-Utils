package exercise1.model.fileEncrypterDecrypter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.SecureRandom;

public class FileEncrypter {


    public static void encrypt(String inputFilePath) throws Exception {
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("The input file does not exist: " + inputFilePath);
        }

        byte[] inputBytes = readFileToBytes(inputFile);

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // 128-bit key size
        SecretKey secretKey = keyGenerator.generateKey();

        byte[] iv = new byte[16];
        SecureRandom.getInstanceStrong().nextBytes(iv); // Generate IV

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));

        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        writeBytesToFile(inputFilePath + ".enc", encryptedBytes); // Encrypted file
        writeBytesToFile(inputFilePath + ".enc.key", secretKey.getEncoded()); // Secret key
        writeBytesToFile(inputFilePath + ".enc.iv", iv); // Initialization vector

        System.out.println("The file has been encrypted: " + inputFilePath + ".enc");
    }

    private static byte[] readFileToBytes(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        }
    }

    private static void writeBytesToFile(String filePath, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
        }
    }
}