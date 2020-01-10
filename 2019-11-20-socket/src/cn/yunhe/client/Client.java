package cn.yunhe.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 * 步骤：
 * 1 发送请求
 * 2 接收结果
 */
public class Client {

    public static void main(String[] args) throws Exception {
        String host = "172.16.34.103";
        int port = 8080;
        PrintStream ps = null;
        Socket socket = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            while (true) {
                //创建socket对象
                socket = new Socket(host, port);
                //获取输出流对象
                ps = new PrintStream(socket.getOutputStream());
                //从控制台获取输入的字符串
                Scanner scan = new Scanner(System.in);
                ps.println(scan.next());

                is = socket.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                String s;
                while ((s = br.readLine()) != null) {
                    System.out.println("服务器推送：" + s);
                }


            }
        } finally {
            //关闭流
            if (br == null) {
                br.close();
            }
            if (isr == null) {
                isr.close();
            }
            if (is == null) {
                is.close();
            }
            if (socket == null) {
                socket.close();
            }
            if (ps == null) {
                ps.close();
            }

        }

    }
}
