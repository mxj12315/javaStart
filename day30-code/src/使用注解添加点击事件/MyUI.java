package 使用注解添加点击事件;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class MyUI {
    @ListenerInstaller(listener = MyActionListener.class, msg = "你点击了确定")
    private final JButton jButton1 = new JButton("确定");
    @ListenerInstaller(listener = MyActionListener.class, msg = "你点击了取消")
    private final JButton jButton2 = new JButton("取消");
    @ListenerInstaller(listener = MyWaitActionListener.class, msg = "你点击了稍等")
    private final JButton jButton3 = new JButton("稍等");
    private final JPanel jp = new JPanel();

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        MyUI myUI = new MyUI();
        myUI.init();
    }

    private void init() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JFrame jFrame = new JFrame();
        ListenerInstallerProcessTools.process(this);
        this.jp.add(jButton1);
        this.jp.add(jButton2);
        this.jp.add(jButton3);

        jFrame.add(jp);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setBounds(100, 100, 500, 309);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MyActionListener implements ActionListener {
    private String message;

    public MyActionListener(String message) {
        this.message = message;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, message);
    }
}

class MyWaitActionListener implements ActionListener {
    private String message;

    public MyWaitActionListener(String message) {
        this.message = message;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(message);
    }
}

