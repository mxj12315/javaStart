import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * URL
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        String path = new String("https://fkjava.org/categories/Java/");
        URL url = new URL(path);
        System.out.println("获取协议:" + url.getProtocol()); // 获取协议
        System.out.println("获取主机:" + url.getHost()); // 获取主机
        System.out.println("获取端口:" + url.getPort()); // 获取端口
        System.out.println("获取用户信息:" + url.getUserInfo());  // 获取用户信息
        System.out.println("获取参数:" + url.getQuery()); // 获取参数
        // 遍历参数
//        for (String s:url.getQuery().split("&")){
//            System.out.println(URLDecoder.decode(s,"utf-8"));
//        }
        try (
                InputStream inputStream = url.openStream();
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(inputStream, "utf-8")
                ) ;
        ){
            String line;
            while ((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }


    }
}
