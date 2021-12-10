import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络编程
 */
public class INetAddressTest {
    public static void main(String[] args) throws IOException {
        // InetAddress inetAddress =InetAddress.getByAddress(new byte[]{(byte) 192, (byte) 168,56,1});
        InetAddress inetAddress =InetAddress.getByName("192.168.2.10");
        System.out.println("获取主机地址："+inetAddress.getHostAddress());  // 获取主机地址
        System.out.println("获取主机名："+inetAddress.getHostName());  // 获取主机名
        System.out.println("是否是本机地址："+inetAddress.isAnyLocalAddress());  // 是否是本机地址
        System.out.println("是否可达："+inetAddress.isReachable(3000));  // 是否可达

    }
}
