package com.aiwenbin.file.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesExample04 {
    public static void main(String[] args) {
        /*
        在相同目录下移动,相当于将input.txt改名位a.txt
         */
      Path source = Paths.get("G:/example/a.txt");
      Path target = Paths.get("G:/example/a.txt");
        try {
            Files.move(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        将目录改名
         */
        Path source1 = Paths.get("G:/example");
        Path target1 = Paths.get("G:/example01");
        try {
            Files.move(source1, target1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
