package cn.yunhe.ioliu;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Ioliu {
    public static void main(String[] args) throws InterruptedException {
        read();
    }

    public static void write() throws InterruptedException {
        FileOutputStream fos = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("E:/�����/text/ҽƷ��ʦ.txt");
            fos = new FileOutputStream("d:/a.txt");
            byte[] bytes = new byte[1024];
            try {
                int len = fis.read(bytes);
                while (len != -1) {

                    fos.write(bytes);
                    len = fis.read(bytes);
                }

            } catch (IOException e) {
                // TODO �Զ����ɵ� catch ��
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    // TODO �Զ����ɵ� catch ��
                    e.printStackTrace();
                }
            }

        }

    }

    public static void read() throws InterruptedException {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("E:\\�����\\text\\����.txt");
            byte[] bytes = new byte[1024];
            int len = fis.read(bytes);
            while (len != -1) {

                String str = new String(bytes, StandardCharsets.UTF_8);
                System.out.println(str);
                len = fis.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO �Զ����ɵ� catch ��
                    e.printStackTrace();
                }
            }

        }

    }

    public static void read1() throws FileNotFoundException {
        FileReader fr = null;

        try {
            fr = new FileReader("E:\\�����\\text\\����.txt");
            char[] cbuf = new char[2];
            int len = fr.read(cbuf);
            while (len != -1) {
                String str = new String(cbuf);
                System.out.println(str);
            }
            // �ر���Դ

        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                // TODO �Զ����ɵ� catch ��
                e.printStackTrace();
            }
        }

    }
}
