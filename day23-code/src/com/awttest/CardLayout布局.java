package com.awttest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * GUI编程  CardLayout布局
 */
public class CardLayout布局 {
    public static void main(String[] args) {
        // new 第一步
        Frame fr  = new Frame("CardLayout布局");
        // set 第二步
        fr.setBounds(0,0,500,500);
        File file =new File("E:\\java\\javaStart\\day23-code\\sucaibar.jpg");
        try {
            BufferedImage icon = ImageIO.read(file);
            fr.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建Panel对象
        Panel panel =new Panel();
        // 设置panel的布局管理器
        panel.setLayout(new CardLayout(10,10));


        // 添加按钮
        Button button = null;
        for (int i = 0; i < 10; i++) {
            button = new Button("按钮" +(i+1));
            panel.add(button);
        }

        // add 第三步
        fr.add(panel);
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
