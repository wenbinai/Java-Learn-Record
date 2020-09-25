package com.aiwenbin.file.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesExample03 {
    public static void main(String[] args) {
       Path source = Paths.get("G:/example/input.txt");
       Path target = Paths.get("G:/example/output.txt");
        try {
//            Files.copy(source, target);
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
