package com.aiwenbin.file.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class FilesExample09 {
    public static void main(String[] args) {

        /*
        删除指定目录下的文件和目录
         */
      Path dir = Paths.get("G:/example");
        try {
            Files.walk(dir)
                    .sorted(Comparator.reverseOrder())
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

    //指定目录下,检索指定文件,并将其删除
    public static void deleteFile(String fileName, String dirName) {
        Path file = Path.of(fileName);
        Path dir = Path.of(dirName);
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

    //删除指定的,包含文件/目录的文件目录
    public static void deleteDir(String dirName) {
        Path dir = Path.of(dirName);
        try {
            Files.walk(dir)
                    .sorted(Comparator.reverseOrder())
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

    //按字符串,读取指定文本中文件的内容
    public static void readStringFromFile(String fileName) {
        Path file = Path.of(fileName);
        String res = null;
        try {
            res = Files.readString(file, Charset.forName("GBK"));
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
