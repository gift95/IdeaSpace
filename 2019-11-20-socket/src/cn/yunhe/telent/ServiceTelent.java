package cn.yunhe.telent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceTelent {
    public static void main(String[] args) throws IOException {
        runTelent(8080);
    }

    public static void runTelent(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket sk = ss.accept();
            ServiceTheard st = new ServiceTheard(sk);
            st.start();
        }
    }
}
