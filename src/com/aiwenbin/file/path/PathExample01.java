package com.aiwenbin.file.path;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;

public class PathExample01 {

    public static void main(String[] args) {
        //获取路径
        Path p = Path.of("G:/tmp/input.txt");
        System.out.println(p);
        System.out.println(p.getClass().getName());
        System.out.println(p.getParent());
        System.out.println(p.getRoot());

    }
}
