package tcp通讯;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // Socket相当于一个插座，两个Socket之间会建立虚拟链路
        Socket socket = new Socket("192.168.2.10",40000);
        //  节点关联到socket
        PrintWriter bf = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
        // 读取屏幕输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        while ((line = br.readLine())!=null){
            //读取网络数据的线程
            new ClientThread(socket).start();

            // 想service断输出数据
            bf.println(line);
            bf.flush();

        }


    }
}


class ClientThread extends Thread {
    private Socket socket;

    public ClientThread(Socket socket){
        this.socket =socket;
    }

    @Override
    public void run(){
        try{
            // 读网络数据输入
            BufferedReader netbr = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));

            String line;
            while ((line = netbr.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}