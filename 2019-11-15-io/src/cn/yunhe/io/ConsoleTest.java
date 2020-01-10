package cn.yunhe.io;

import java.io.*;

/**
 * �����ڿ���̨���������ݣ���ȡ����Ӧ�����ݺ��ڿ���̨�������
 * ���裺
 * 1 �����̨��������
 * 2 ��ȡ����̨���������
 * 3 ���������������̨
 */
public class ConsoleTest {

    public static void main(String[] args) throws IOException {
        //�ֽ���--���Ի�ȡ����̨������
        InputStream is = System.in;
        //��Ҫʹ���ַ������ж�ȡ�Ա����������
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        String str = "";
        while ((str = br.readLine()) != null) {
            //������������Ϊover������ù���
            if (str.equals("over")) {
                return;
            }
            System.out.println(str);
        }
    }
}
