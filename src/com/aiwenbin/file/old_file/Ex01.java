package com.aiwenbin.file.old_file;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        File file = new File("H:\\Java\\java11-study\\src\\com\\aiwenbin\\file\\old_file\\tmp.txt");

        System.out.println(file.exists());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        System.out.println(file.getTotalSpace());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }
}
