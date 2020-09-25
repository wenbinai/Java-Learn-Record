package com.aiwenbin.file.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesExample05 {
    public static void main(String[] args) {
        /*
        移动文件
         */
       Path source = Paths.get("G:/example/a.txt");
       Path target = Paths.get("G:/example/");
        try {
            Files.move(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
