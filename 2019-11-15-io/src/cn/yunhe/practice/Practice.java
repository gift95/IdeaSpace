package cn.yunhe.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ�����
 */
public class Practice {

    public static void main(String[] args) throws IOException {
        String path = "e:/io.txt";
        String copyPath = "e:/copyio.txt";
        copyFile(path, copyPath);
    }


    /**
     * 1 ָ��Ҫ���Ƶ��ļ�·��
     * 2 ��ȡ�ļ�����
     * 3 ���ļ�����д���µ��ļ���
     *
     * @throws IOException
     */
    public static void copyFile(String path, String outPath) throws IOException {

        //��ȡָ��·����������������ж�ȡ����
        FileInputStream fis = new FileInputStream(path);
        //����ȡ��������д���µ��ļ���---������ļ�����--ָ��д���ļ�·��
        FileOutputStream fos = new FileOutputStream(outPath);

        //�����ȡ�Ļ�����
        byte[] bytes = new byte[1024];
        //�����ݶ�ȡ����������
        int len = -1;
        //�ж��Ƿ��ȡ�����ļ���ĩβ
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes);
        }

        //�ر�������
        fos.close();
        fis.close();
    }
}
