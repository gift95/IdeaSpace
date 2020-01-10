package cn.yunhe.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * \
 * 客户端
 * 1 将要获取的行数发送给服务端
 * 2 将服务端返回的结果在控制台回显
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        //定义地址
        String host = "localhost";
        //定义端口
        int port = 8889;

        while (true) {
            //创建一个Socket对象
            Socket client = new Socket(host, port);
            //将获取到的结果发送给服务端--其实就是使用输出流进行输出操作
            PrintStream ps = new PrintStream(client.getOutputStream());
            //从控制台获取输入的值
            Scanner scan = new Scanner(System.in);
            String lineContent = scan.next();
            ps.print(lineContent);
            ps.println();

            InputStream is = client.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String s;
            while ((s = br.readLine()) != null) {
                System.out.println("服务器推送：" + s);
            }

            client.shutdownInput();
            ps.close();
            client.close();
        }
    }
}
