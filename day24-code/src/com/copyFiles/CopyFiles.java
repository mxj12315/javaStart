package com.copyFiles;

import java.io.*;

public class CopyFiles {



    public static void main(String[] args)  {
        CopyFiles notAnonymous = new CopyFiles();
        try {
            notAnonymous.copyFolder("E:\\暂时存放\\2020年12月23号备份", "D:\\hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyFolder(String src, String dest) throws IOException {
        File file = new File(src);
        if (file.isDirectory()){
//            System.out.println( "目标路径创建文件夹");
            // 目标路径创建文件夹
            File newFie = new File(dest + File.separatorChar +file.getName());
            newFie.mkdirs();

            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                copyFolder(files[i].getCanonicalPath(),newFie.getCanonicalPath());
            }
        }else {
            copyFile(src,dest +File.separatorChar+ file.getName() );
        }

    }

    private void copyFile(String src, String dest) throws  IOException{
        System.out.println("src:"+src);
        System.out.println("dest:"+dest);
        BufferedOutputStream fos = null;
        BufferedInputStream fis = null;
        fis =new BufferedInputStream(new FileInputStream(src));
        fos = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] bytes = new byte[1024];
        int j = 0;
        while ((j = fis.read(bytes))>0 ){
            fos.write(bytes,0,j);
        }
    }

}