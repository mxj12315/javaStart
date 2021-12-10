package udp通讯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP客户端，即使没有服务端也可以运行
 */
public class Client {
    private static final String SERVICE_IP = "192.168.2.10";
    private static final int SERVICE_PORT = 35000;


    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(); // 使用本机默认的IP
        InetAddress inetAddress =InetAddress.getByName(SERVICE_IP);  // 将IP转换为InetAddress
        // 开启子线程
        new ClientThread(datagramSocket).start();

        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        while ((message = bf.readLine())!=null){
            byte[] buf = message.getBytes();
            // 创建data集装箱
            DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length,inetAddress,SERVICE_PORT);
            // 发送集装箱
            datagramSocket.send(datagramPacket);

        }



    }
}

/**
 * 客户端子线程
 */
class ClientThread extends Thread {
    private DatagramSocket datagramSocket;

    public ClientThread(DatagramSocket datagramSocket){
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run(){
        // 定义一个空的集装箱，用于接受数据
        byte[] buf = new byte[4096];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        // 循环收集数据包
        while (true){
            try {
                datagramSocket.receive(packet);
                System.out.println("得到字节数组：" + new String(packet.getData(), "utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
