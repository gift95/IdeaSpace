package cn.yunhe.io;

import java.io.*;

/**
 * �ַ���
 * Reader
 * FileReader
 * Writer
 * FileWriter
 */
public class IODemo {

    public static void main(String[] args) throws IOException {
//		readerMethod2();
//		writerMethod2();
//		bufferedReader();
//		bufferedWriter();

        String readerPath = "e:/io.txt";
        String writerPath = "e:/ioCopy.txt";
        copy(readerPath, writerPath);
    }


    /**
     * �ַ�����ȡ����
     *
     * @throws IOException
     */
    public static void readerMethod1() throws IOException {
        //��ȡ�ַ����ļ�����������
        FileReader fr = new FileReader("e:/io.txt");
        //�����ַ���ȡ����������
        char[] cbuf = new char[1024];
        int len = -1;
        String str = "";
        while ((len = fr.read(cbuf)) != -1) {
            //���ַ�����ת��Ϊ�ַ���
            str = str + new String(cbuf);
        }
        System.out.println(str);
        //�ر���
        fr.close();
    }

    /**
     * �ַ�����ȡ����
     *
     * @throws IOException
     */
    public static void readerMethod2() throws IOException {
        //��ȡ�ַ����ļ�����������
        FileReader fr = new FileReader("e:/io.txt");
        //�����ַ���ȡ����������
        char[] cbuf = new char[1024];
        int len = -1;
        StringBuilder sb = new StringBuilder();
        while ((len = fr.read(cbuf)) != -1) {
            sb.append(cbuf);
        }
        System.out.println(sb.toString());
        //�ر���
        fr.close();
    }

    /**
     * �ַ���д������
     *
     * @throws IOException
     */
    public static void writerMethod() throws IOException {
        //�����ַ����������
        FileWriter fw = new FileWriter("e:/strIo.txt", true);
        //д����
        fw.write(18);
        //ˢ����
        //fw.flush();
        fw.write("С��");
        //fw.flush();

        fw.close();
    }

    /**
     * �ַ��������ļ�
     *
     * @throws IOException
     */
    public static void writerMethod2() throws IOException {
        //�����ַ�����������
        FileReader fr = new FileReader("e:/io.txt");
        //�����ַ����������
        FileWriter fw = new FileWriter("e:/copyIO.txt", true);

        //�����ַ�������
        char[] cbuf = new char[1024];
        //���ж�ȡ
        int len = -1;
        while ((len = fr.read(cbuf)) != -1) {
            //����ȡ��������д���µ��ļ���
            fw.write(cbuf);
        }

        //�ر���
        fw.close();
        fr.close();
    }

    /**
     * ʹ���ַ������������ж�ȡ����
     *
     * @throws IOException
     */
    public static void bufferedReader() throws IOException {
        //�����ַ�����������
        Reader reader = new FileReader("e:/io.txt");
        //�����ַ����������
        BufferedReader br = new BufferedReader(reader);
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        //�ر�������ʱע�⣺Ҫ�Ӻ���ǰ��
        br.close();
        reader.close();
    }

    /**
     * �ַ�������еĻ��в���--newLine()
     *
     * @throws IOException
     */
    public static void bufferedWriter() throws IOException {
        //�����ַ����������
        Writer writer = new FileWriter("e:/writer.txt");
        //�����ַ�������������
        BufferedWriter bw = new BufferedWriter(writer);
        //д����
        bw.write("С��˵�껰�ͻ���");
        bw.newLine();
        bw.write("С��˵");

        //�ر�������
        bw.close();
        writer.close();
    }

    /**
     * ʹ���ַ��������������ݶ�ȡ
     *
     * @param readerPath
     * @param writerPath
     * @throws IOException
     */
    public static void copy(String readerPath, String writerPath) throws IOException {
        //�����ַ�����������
        FileReader fr = new FileReader(readerPath);
        //�����ַ��������������
        BufferedReader br = new BufferedReader(fr);
        //�����ַ����������
        FileWriter fw = new FileWriter(writerPath);
        //�����ַ�������������
        BufferedWriter bw = new BufferedWriter(fw);
        String result = "";
        while ((result = br.readLine()) != null) {
            bw.write(result);
            bw.newLine();
        }

        //�ر�������
        bw.close();
        fw.close();
        br.close();
        fr.close();
    }
}
