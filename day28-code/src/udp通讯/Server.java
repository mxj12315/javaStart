package udp通讯;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.*;

/**
 * UDP通讯接收端
 */
public class Server {
    private static final int PORT = 35000;
    private static final String IP = "192.168.2.10";
    private static Set<SocketAddress> addressSet = Collections.synchronizedSet(new LinkedHashSet<>());  // 包装成线程安全的集合

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName(IP);  // IP地址
        DatagramSocket datagramSocket = new DatagramSocket(PORT, inetAddress);  // 创建socket
        // 定义一个空的集装箱，用于接受数据
        byte[] buf = new byte[4096];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // 死循环一直捞取data集装箱
        while (true) {
            datagramSocket.receive(packet);
            // System.out.println("得到字节数组：" + new String(packet.getData(), "utf-8"));
            // System.out.println("得到数据长度："+packet.getLength());


            SocketAddress socketAddress = packet.getSocketAddress(); // IP+PORT
            addressSet.add(socketAddress); // 将每一个IP+port加入集合
            Iterator<SocketAddress> iterator =addressSet.iterator();
            // 遍历集合元素，向每一个集合中的socketAddress发送信息
            while (iterator.hasNext()){
                SocketAddress next = iterator.next(); // 获取下一个
                packet.setSocketAddress(next); // 修改当前的数据包的ip和端口
                datagramSocket.send(packet);  // 发送数据包
            }

        }


    }
}
