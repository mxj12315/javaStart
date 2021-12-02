package com.compileTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.io.*;

/**
 * 编译工具
 */
public class CompileTool {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("CompileTool");
        jFrame.setLayout(new BorderLayout(100, 10));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        Runtime runtime = Runtime.getRuntime();
        JTextField jTextField = new JTextField(80);
        JButton jButton = new JButton("Compile");
        JTextArea jTextArea = new JTextArea(10, 80);
        jTextArea.setEnabled(false);
        jTextArea.setBackground(Color.white);



        jPanel.add(jTextField, BorderLayout.WEST);
        jPanel.add(jButton);

        jFrame.add(new JScrollPane(jTextArea), BorderLayout.CENTER);
        jFrame.add(jPanel, BorderLayout.NORTH);

        jFrame.pack();
        jFrame.setVisible(true);
        // 点击编译按钮的处理逻辑
        jButton.addActionListener(e -> {
            String cmd = "javac -encoding utf-8 -d . " + jTextField.getText().trim();
            try {
                Process process = runtime.exec(cmd);
                InputStream outputStream = process.getErrorStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(outputStream));
                String s ;
                StringBuffer stringBuffer = new StringBuffer();
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuffer.append(s + "\n");
                }
                // 没有读到信息
                if (stringBuffer.length() == 0) {
                    jTextArea.setText("编译完成！");
                } else {
                    jTextArea.setText(stringBuffer.toString());
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
