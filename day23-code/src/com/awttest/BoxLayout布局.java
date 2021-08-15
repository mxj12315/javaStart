package com.awttest;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * GUI编程  BoxLayout布局
 */
public class BoxLayout布局 {
    public static void main(String[] args) {
        // new 第一步
        Frame fr  = new Frame("BoxLayout布局");
        // set 第二步
        fr.setBounds(0,0,500,500);
        File file =new File("E:\\java\\javaStart\\day23-code\\sucaibar.jpg");
        try {
            BufferedImage icon = ImageIO.read(file);
            fr.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 第一步new
        Box box = new Box(BoxLayout.X_AXIS);  // 大箱子
        Box box1 = new Box(BoxLayout.Y_AXIS);
        Box box2 = new Box(BoxLayout.Y_AXIS);
        Box box3 = new Box(BoxLayout.Y_AXIS);
        // 添加到大box中
        box.add(box1);
        box.add(box2);
        box.add(box3);

        // 第一个box1里面上面有两个Button
        Box upBox = new Box(BoxLayout.X_AXIS);
        Box downBox = new Box(BoxLayout.X_AXIS);
        Button buttonLeft = new Button("1");
        Button buttonRight = new Button("2");
        Button buttonZero = new Button("0");

        upBox.add(buttonLeft);
        upBox.add(buttonRight);
        downBox.add(buttonZero);
        box1.add(upBox);
        box1.add(downBox);


        // 第二个box2中添加上下两个
        Button buttonThree = new Button("3");
        Button buttonPoint = new Button(".");
        box2.add(buttonThree);
        box2.add(buttonPoint);

        // 第三个box3中添加一个
        Button buttonEquals = new Button("=");
        box3.add(buttonEquals);


        // add 第三步
        fr.add(box);
        fr.setVisible(true);


        // 监听关闭
        fr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
