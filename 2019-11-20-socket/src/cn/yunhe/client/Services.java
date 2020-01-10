package cn.yunhe.client;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Services {
    private static List<String> sentence = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int port = 88;


        //读取文件 将其存放到集合中
        FileReader fr = new FileReader("D:/IdeaSpace/2019-11-20-socket/src/english.txt");
        BufferedReader br = new BufferedReader(fr);
        String len;
        while ((len = br.readLine()) != null) {
            sentence.add(len);
        }
        /*
         *
         *定义一个服务端用来接收客户端发来的信息
         */
        ServerSocket ssc = new ServerSocket(port);

        while (true) {
            Socket so = ssc.accept();
            Reader is = new InputStreamReader(so.getInputStream());
            BufferedReader bfr = new BufferedReader(is);
            String str = bfr.readLine();
            System.out.println("接收到客户端的信息：" + str);
            //显示链接的主机
            InetAddress ipObject = so.getInetAddress();
            String ip = ipObject.getHostAddress();
            System.out.println("已连接的主机IP:" + ip);
            //创建一个打印输出流 返回数据
            PrintStream ps = new PrintStream(so.getOutputStream());
            //关闭接收流
            so.shutdownInput();


            String[] strArr = str.split(",");
            for (String s : strArr
            ) {
                ps.println(sentence.get((Integer.valueOf(s) - 1) % sentence.size()));
            }
            ps.close();
            bfr.close();
            is.close();


        }
    }
}
