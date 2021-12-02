package com.systemIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 重定向出入输入输出
 */
public class SystemIO {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\mxj12315\\Desktop\\abc.log");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            PrintStream printStream = new PrintStream(file);
            System.setOut(printStream);
            System.out.println("123456");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
