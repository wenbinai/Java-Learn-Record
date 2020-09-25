package com.aiwenbin.exam.Exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:/example/file1.txt";
        String toFile = "C:/example/file2.txt";
        copyFile(fileName, toFile);
    }

    public static void copyFile(String fileName, String toFile) {
        byte[] buffer = new byte[512];
        int len = 0;
        try(FileInputStream in = new FileInputStream(fileName);
            FileOutputStream out = new FileOutputStream(toFile)
            ) {
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            String addText = "艾文斌-20182144-江西省抚州市";
            out.write(addText.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
