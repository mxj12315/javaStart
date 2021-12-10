package udp通讯.MultiSocket广播;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 不需要服务端
 */
public class MultiSocketClient {
    private static final String MULTISOCKET_SERVICE_IP = "230.0.0.1";  // 广播IP
    private static final int MULTISOCKET_SERVICE_PORT = 35000; // 广播端口


    public static void main(String[] args) throws IOException {
        MulticastSocket multicastSocket = new MulticastSocket(MULTISOCKET_SERVICE_PORT); // 使用本机默认的IP
        multicastSocket.setTimeToLive(64); // 控制数据包只广播到本地区
        InetAddress inetAddress = InetAddress.getByName(MULTISOCKET_SERVICE_IP);  // 将IP转换为InetAddress
        multicastSocket.joinGroup(inetAddress); // 加入广播地址
        // 开启子线程
        new MultiSocketClientThread(multicastSocket).start();

        // 获取系统输入System.in，包装为输入流BufferedReader
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        while ((message = bf.readLine()) != null) {
            // 数据装换为字节数组
            byte[] buf = message.getBytes();
            // 创建data集装箱
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, inetAddress, MULTISOCKET_SERVICE_PORT);
            // 发送集装箱
            multicastSocket.send(datagramPacket);


        }
    }
}


/**
 * 广播客户端子线程，负责打捞数据包
 */
class MultiSocketClientThread extends Thread {
    private MulticastSocket multicastSocket;

    public MultiSocketClientThread(MulticastSocket multicastSocket){
        this.multicastSocket = multicastSocket;
    }

    @Override
    public void run(){
        // 定义一个空的集装箱，用于接受数据
        byte[] buf = new byte[4096];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        // 循环收集数据包
        while (true){
            try {
                multicastSocket.receive(packet);
                System.out.println("得到字节数组：" + new String(packet.getData(), "utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
