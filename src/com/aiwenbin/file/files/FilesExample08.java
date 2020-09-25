package com.aiwenbin.file.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample08 {
    public static void main(String[] args) {
       Path dir = Paths.get("G:/example");
       Path file = Paths.get("a.txt");

        try {
            Files.walk(dir)
                    .filter(p -> p.equals(file))
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
