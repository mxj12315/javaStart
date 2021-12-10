package tcp通讯;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Server {
    public static List<Socket> socketList=Collections.synchronizedList(new LinkedList<>());  // 用于存放所有的Socket

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(40000);
        while (true) {
            // 开始接收服务端的消息
            Socket accept = socket.accept();
            // 将进入的每个Socket放入集合中
            socketList.add(accept);

            // 通知在线用户数
            PrintWriter  pwme = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()));
            // pwme.println("当前共有"+socketList.size()+"在线");
             pwme.println("当前共有在线");
            pwme.flush();
            System.out.println("53312332123");
            // 子线程用于处理子线程的消息
            new ServerThread(accept,socketList).start();
        }

    }
}

class ServerThread extends Thread {
    private Socket socket;
    private List<Socket> socketList;

    public ServerThread(Socket socket,List<Socket> socketList) {
        this.socket = socket;
        this.socketList = socketList;
    }

    @Override
    public void run() {
        try {


            // 输入流
            BufferedReader  bf = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            String line;
            while ((line = bf.readLine()) != null) {

                //遍历socketList
                for (Socket s/*代表每一个用户*/:socketList) {
                    if (s!=socket){
                        // 输出流
                        PrintWriter  pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                        System.out.println("Service:"+ line);
                        pw.println(line);
                        pw.flush();
                    }

                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
