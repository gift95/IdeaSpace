package cn.yunhe.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServiceDemo {


    /**
     * 定义一个集合，用于存放指定文件的全部内容
     */
    private static List<String> sentence = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //定义端口
        int port = 8889;

        //读取指定文件，将内容存放在集合中
        FileReader fr = new FileReader("D:/IdeaSpace/2019-11-20-socket/src/english.txt");
        //因为是按行来获取数据的，所以此处将内容按行的形式进行存储
        BufferedReader bfr = new BufferedReader(fr);
        String lineContent = null;
        while ((lineContent = bfr.readLine()) != null) {
            sentence.add(lineContent);
        }
        //创建ServerSocket
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            //获取客户端发送过来的信息
            Reader reader = new InputStreamReader(socket.getInputStream());
            //缓冲流按行读取
            BufferedReader br = new BufferedReader(reader);
            //读取到客户端发送过来的内容--内容要求格式x,x,x
            String clientContent = br.readLine();
            System.out.println("接收到客户端的信息：" + clientContent);
            //创建一个打印流返回数据
            PrintStream ps = new PrintStream(socket.getOutputStream());
            //按,对内容进行分割
            String[] lineNumbers = clientContent.split(",");
            socket.shutdownInput();
            for (String line : lineNumbers) {
                ps.print(sentence.get((Integer.parseInt(line) - 1) % sentence.size()) + "\n");
            }
            ps.close();
            br.close();
            reader.close();
        }
    }
}