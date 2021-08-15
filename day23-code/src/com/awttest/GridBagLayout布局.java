package com.awttest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * GUI编程  GridBagLayout布局
 */
public class GridBagLayout布局 {
    public static void main(String[] args) {
        // new 第一步
        Frame fr  = new Frame("GridBagLayout布局");
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
        GridBagLayout gb = new GridBagLayout();
        panel.setLayout(gb);

        //创建GridBagConstraints对象，并设置该对象的相关属性（用于设置受该对象控制的GUI组件的大小、跨越性等）
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2; // 设置受该对象控制的GUI组件位于网络的横向索引
        gbc.gridy = 1; // 设置受该对象控制的GUI组件位于网络的纵向索引
        gbc.gridwidth = 2; // 设置受该对象控制的GUI组件横向跨越多少网格
        gbc.gridheight = 1; // 设置受该对象控制的GUI组件纵向跨越多少网格

        Button button = new Button("anniu");
        gb.setConstraints(button, gbc); //设置c组件受gbc对象控制
        panel.add(button);
        // 添加按钮
//        Button button = null;
//        for (int i = 0; i < 10; i++) {
//            button = new Button("按钮" +(i+1));
//            panel.add(button,i);
//        }

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
