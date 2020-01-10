package Servicesss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 步骤：
 * 1 指定一个端口号，用于标识该服务是给谁提供的
 * 2 根据提供的端口号创建对应的服务
 * 3 接收客户端发送的请求---accept()
 */
public class ServiceEntry {

    public static void main(String[] args) throws IOException {
        //指定端口号
        int port = 8888;
        //创建服务端socket对象
        ServerSocket serverSocket = new ServerSocket(port);
        //接收客户端发送过来的请求
        Socket socket = serverSocket.accept();
        //通过流的形式获取客户端发送的信息
        Reader reader = new InputStreamReader(socket.getInputStream());
        //按行读取
        BufferedReader br = new BufferedReader(reader);
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        br.close();
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
