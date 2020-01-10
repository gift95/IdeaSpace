package cn.yunhe.telent;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ClientTelent {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        String host = "localhost";
        PrintStream ps = null;
        Socket socket = null;
        InputStream is = null;
        InputStreamReader isr;
        BufferedReader br = null;
        InetAddress ip = null;
        String sdt = null;


        ps = new PrintStream(new Socket(host, port).getOutputStream());
        ps.println("已登陆");
        while (true) {
            try {
                socket = new Socket(host, port);
                ip = socket.getInetAddress();
                ps = new PrintStream(socket.getOutputStream());
                //从控制台获取输入的字符串
                Scanner scan = new Scanner(System.in);
                ps.println(scan.next());


            } catch (IOException e) {
                e.printStackTrace();
            }


            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String s;
            while ((s = br.readLine()) != null) {
                sdt = ServiceTheard.getTime(new Date());
                System.out.println("来自" + ip + "时间" + sdt + "\n推送：\n" + s);
            }

            ps.flush();

        }

    }
}
