package com.aiwenbin.input_output_examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputExample01 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream in = new FileInputStream("G:/input.txt");
        FileOutputStream out = new FileOutputStream("G:/output.txt");
        int c;

    }
}
