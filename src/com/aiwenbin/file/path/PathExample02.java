package com.aiwenbin.file.path;

import java.nio.file.Path;

public class PathExample02 {

    /*
    三种拼接路径的实现
     */
    public static void main(String[] args) {
       Path dir = Path.of("G:/example");
       Path file = Path.of("input.txt");
       Path p1 = dir.resolve(file);
       System.out.println(p1);

       Path p2 = Path.of("G:/example/input.txt");
        System.out.println(p2.equals(p1));

        Path p3 = Path.of("G:/", "example/", "input.txt");
        System.out.println(p3.equals(p1));
    }
}
