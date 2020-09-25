package com.aiwenbin.experiment08;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class IOTest {
    public static void main(String[] args) {
        String fileName = "C:/example/from.txt";

        System.out.println("----- 创建文件 ------");
        createFile(fileName);

        System.out.println("-----  将字符串写入文件 -------");
        // \r\n在txt文本中换行
        String str =
                "白日依山尽\r\n" +
                        "黄河入海流\r\n" +
                        "欲穷千里目\r\n" +
                        "更上一层楼\r\n";
        writeToFile(fileName, str);

        System.out.println("--------- 基于基本IO流实现文件的复制 ----------");
        String toFile = "C:/example/to.txt";
        copyByIO(fileName, toFile);

        System.out.println("--------- 基于NIO实现文件的复制 ----------");
        String toFile2 = "C:/example/nio/to.txt";
        copyByIO(fileName, toFile2);

        System.out.println("---------- 删除指定文件 -------------");
        deleteFile(toFile);
        System.out.println("---------- 遍历指定目录文件 -------------");
        String dir = "C:/example";
        walkDirectories(dir);
    }

    /**
     * 基于指定文件名称创建目录及文件
     * 如果文件已经存在，则忽略
     *
     * @param fileName
     */
    private static void createFile(String fileName) {
        Path file = Path.of(fileName);
        try {
            Files.createDirectories(file.getParent());
            if(! Files.exists(file)) {
                Files.createFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提示：文件以字节操作，因此可以
     * 字符串，转字节数组，直接基于Files写入文件
     *
     * @param fileName
     * @param content
     */
    private static void writeToFile(String fileName, String content) {
        try(FileOutputStream out = new FileOutputStream(fileName);
        ) {
           out.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于基本IO，以及字节数组缓冲区，复制文件
     * 打印显示循环读写循环次数
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByIO(String sourceFile, String targetFile) {
        createFile(targetFile);
        try(FileInputStream in = new FileInputStream(sourceFile);
            FileOutputStream out = new FileOutputStream(targetFile);) {
            byte[] buffer = new byte[4];
            int len;
            int num = 0;
            while((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
                num ++;
            }
            System.out.println(num);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 基于NIO，实现文件的复制
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByNIO(String sourceFile, String targetFile) {
        Path source = Path.of(sourceFile);
        Path target = Path.of(targetFile);
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    private static void deleteFile(String fileName) {
        Path file = Path.of(fileName);
        try {
            Files.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历打印指定目录下全部目录/文件名称
     *
     * @param dir
     */
    private static void walkDirectories(String dir) {
        Path directory = Path.of(dir);
        try {
            Files.walk(directory)
                    .forEach(p -> System.out.println(p.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

