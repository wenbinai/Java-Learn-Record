package com.aiwenbin.file.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample07 {
    public static void main(String[] args) {
       Path dir = Paths.get("G:/example");
        try {
            Files.walk(dir).forEach(p -> System.out.println(p.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
