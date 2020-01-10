package cn.yunhe.telent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ServiceTheard extends Thread {
    Socket sk;
    Date date = null;

    public ServiceTheard(Socket sk) {
        this.sk = sk;
    }

    public static String getTime(Date date) {
        SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
        String sdtt = sdt.format(date);
        return sdtt;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {

            InetAddress ipObj = sk.getInetAddress();
            String ip = ipObj.getHostAddress();

            br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            String line = br.readLine();

            String time = getTime(new Date());

            System.out.println("客户端：\n" + ip + "\t发送时间" + time + "\n消息:\n" + line);
            sk.shutdownInput();

            PrintStream ps = new PrintStream(sk.getOutputStream());
            System.out.print("发送：\n");
            Scanner sn = new Scanner(System.in);
            String str = sn.nextLine();
            ps.println(str);


            ps.flush();
            br.close();
            sk.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
