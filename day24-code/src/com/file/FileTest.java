package com.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        String absolutePath = file.getAbsolutePath(); // 得到绝对路径
        File canonicalFile = file.getCanonicalFile(); // 得到规范路径
        boolean absolute = file.isAbsolute();  // 是否是绝对路径
        boolean directory = file.isDirectory();// 是否是目录
        boolean exists = file.exists();  // 是否存在

        System.out.println(absolutePath);
        System.out.println(canonicalFile);
        System.out.println("是否是绝对路径:" + absolute);
        System.out.println("是否是目录:"+directory);
        System.out.println("是否存在:"+exists);
    }
}
