package cn.yunhe.Ioliu;

import java.io.*;

public class StringBuffered implements Runnable {

    public static void Read() throws IOException {
        Reader fr = new FileReader("e:/a.txt");
        BufferedReader br = new BufferedReader(fr);
        String str = "";
        while ((str = br.readLine()) != null) {
            try {
                Thread.sleep(400);
                System.out.println(str);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        br.close();
        fr.close();

    }

    public static void write() throws IOException {
        Reader fr = new FileReader("e:/a.txt");
        BufferedReader br = new BufferedReader(fr);
        Writer fw = new FileWriter("e:/b.md");
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
        }
        bw.close();
        fw.close();
        br.close();
        fr.close();

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
