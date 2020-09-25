package com.aiwenbin.serial;

import com.aiwenbin.mulit_status_example.F;
import com.aiwenbin.mulit_status_example.S;

import java.io.*;

public class SerialDemo01 implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long id;

    public String name;

    public final String userName;

    public SerialDemo01(Long id, String name) {
        this.id = id;
        this.name = name;
        userName = "ddbbb";
    }

    public static void main(String[] args) {
        SerialDemo01 serialDemo01 = new SerialDemo01(1L, "aiwenbin");
        System.out.println(serialDemo01);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("tmp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serialDemo01);
            oos.flush();;
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SerialDemo01 serialDemo011;
        try {
            FileInputStream fis = new FileInputStream("tmp.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            serialDemo011 = (SerialDemo01) ois.readObject();
            ois.close();
            System.out.println(serialDemo011.toString());
            System.out.println(serialDemo011.userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
