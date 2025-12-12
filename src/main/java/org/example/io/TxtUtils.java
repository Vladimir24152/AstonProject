package org.example.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TxtUtils {
    public static String readFile(String fileName) {
        try {
            Path path = Paths.get(String.format(
                    "%s\\src\\main\\resources\\%s",
                    System.getProperty("user.dir"),
                    fileName));
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
