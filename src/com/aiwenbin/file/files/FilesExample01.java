package com.aiwenbin.file.files;

import java.nio.file.Files;
import java.nio.file.Path;

public class FilesExample01 {
    public static void main(String[] args) {
        Path p = Path.of("G:/aaa");
        System.out.println(Files.exists(p));
        System.out.println("目录: " + Files.isDirectory(p));
        Path p2 = Path.of("G:/example");
        System.out.println(Files.exists(p2));
        System.out.println("目录: " + Files.isDirectory(p2));
        Path p3 = Path.of("G:/example/input.txt");
        System.out.println(Files.exists(p3));
        System.out.println("目录: " + Files.isDirectory(p3));
    }
}
