package exercise1.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListDirectoryAlphabetically {
    // Implements the functionality to list a directory tree recursively
    public static void listDirectoryTree(String path) {
        File directory = new File(path);

        if (!directory.isDirectory()) {
            System.out.println(path + " is not a valid directory.");
            return;
        }

        System.out.println("Directory contents:");

        listDirectoryRecursive(directory, 0);
    }

    private static void listDirectoryRecursive(File directory, int level) {
        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Cannot list files in: " + directory.getAbsolutePath());
            return;
        }

        Arrays.sort(files);

        for (File file : files) {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }

            char type = file.isDirectory() ? 'D' : 'F';

            String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());

            System.out.printf("[%c] %s - Last modified: %s%n", type, file.getName(), lastModified);

            if (file.isDirectory()) {
                listDirectoryRecursive(file, level + 1);
            }
        }
    }
}