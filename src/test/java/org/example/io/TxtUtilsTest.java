package org.example.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TxtUtilsTest {

    private File file = new File("src/main/resources/test1.txt");
    private String line = "Владимир|Горлов|101|4.5|1234567|23|Саратов, ул. Саратовская, д5, кв. 30;";

    @Test
    void whenCreateFile_FileIsExists() {
        TxtUtils.createFile("test1");
        assertTrue(file.exists());
    }


    @Test
    void checkFileExists() {
        TxtUtils.createFile("test1");
        assertTrue(TxtUtils.checkFileExists("test1"));
    }

    @Test
    void writeLine() {
        TxtUtils.createFile("test1");
        TxtUtils.writeLine(line,"test1");
    }

    @Test
    void readFile() {
        TxtUtils.createFile("test1");
        TxtUtils.writeLine(line,"test1");
        assertEquals(line + "\n",TxtUtils.readFile("test1"));
    }

    @BeforeEach
    void theEnd(){
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}