package com.printStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 打印流
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        try {
            // System.out 本质就是打印流
            String filePath = "C:\\Users\\mxj12315\\Desktop\\123456.txt";
            PrintStream printStream = new PrintStream(filePath);
            InputStream inputStream = new FileInputStream(filePath);
            printChunXiao(printStream);
            scannerChunXiao(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void scannerChunXiao(InputStream inputStream) {
        Scanner sc = new Scanner(inputStream);
        while (sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    }

    private static void printChunXiao(PrintStream printStream) {
        printStream.println("  春晓 ");
        printStream.println("春眠不觉晓，");
        printStream.println("处处闻啼鸟。");
        printStream.println("夜来风雨声，");
        printStream.println("花落知多少。");
    }

}
