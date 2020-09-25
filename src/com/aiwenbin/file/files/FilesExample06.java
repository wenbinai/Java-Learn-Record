package com.aiwenbin.file.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesExample06 {
    public static void main(String[] args) {
       Path dir = Paths.get("G:/exmaple/e");
        try {
            Files.createDirectories(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
