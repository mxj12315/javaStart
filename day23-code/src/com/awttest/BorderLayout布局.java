package com.awttest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * GUI编程  BorderLayout布局
 */
public class BorderLayout布局 {
    public static void main(String[] args) {
        // new 第一步
        Frame fr  = new Frame("BorderLayout布局");
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
        panel.setLayout(new BorderLayout(1,1));


        // 添加按钮
        Button button1 = new Button("中间");
        Button button2 = new Button("北边");
        Button button3 = new Button("南边");
        Button button4 = new Button("东边");
        Button button5 = new Button("西边");
        // 添加到Panel对象
        panel.add(button1,BorderLayout.CENTER);
        panel.add(button2,BorderLayout.NORTH);
        panel.add(button3,BorderLayout.SOUTH);
        panel.add(button4,BorderLayout.EAST);
        panel.add(button5,BorderLayout.WEST);

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
