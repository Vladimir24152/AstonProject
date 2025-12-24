package org.example.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TxtUtils {
    private static final String WORK_DIR_PATH;

    public static boolean checkFileExists(String fileName) {
        Path path = Paths.get(String.format(
                "%s%s.txt",
                WORK_DIR_PATH,
                fileName)
        );
        return Files.exists(path);
    }

    public static void createFile(String fileName) {
        try {
            Path path = Paths.get(String.format(
                    "%s%s.txt",
                    WORK_DIR_PATH,
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
                    WORK_DIR_PATH,
                    fileName)
            );
            return Files.readString(path, StandardCharsets.UTF_8);
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
                    WORK_DIR_PATH,
                    fileName)
            );

            String newLine = line + "\n";

            Files.write(path, newLine.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        String userDir = System.getProperty("user.dir");
        if (userDir.contains("target")) {
            WORK_DIR_PATH = userDir.replace("target", "src/main/resources/");
        } else {
            WORK_DIR_PATH = userDir + "/src/main/resources/";
        }
    }
}
