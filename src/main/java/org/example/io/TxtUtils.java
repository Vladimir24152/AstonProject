package org.example.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TxtUtils {

    private static final String workDirPath = String.format(
            "%s\\src\\main\\resources\\",
            System.getProperty("user.dir")
    );

    private static boolean checkFileExists(String fileName) {
        Path path = Paths.get(String.format(
                "%s%s.txt",
                workDirPath,
                fileName)
        );
        return Files.exists(path);
    }

    private static void createFile(String fileName) {
        try {
            Path path = Paths.get(String.format(
                    "%s%s.txt",
                    workDirPath,
                    fileName)
            );
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String fileName) {
        try {
            Path path = Paths.get(String.format(
                    "%s%s.txt",
                    workDirPath,
                    fileName)
            );
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void writeLine(String line, String fileName) {
        // 1. check file exists
        // 2. append
        if (!checkFileExists(fileName)) {
            createFile(fileName);
        }

        try {
            Path path = Paths.get(String.format(
                    "%s%s.txt",
                    workDirPath,
                    fileName)
            );

            String newLine = line + "\n";

            Files.write(path, newLine.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
