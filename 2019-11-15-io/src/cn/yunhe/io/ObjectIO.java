package cn.yunhe.io;

import cn.yunhe.beans.User;

import java.io.*;

/**
 * �־û��洢
 * �����ݱ��ػ��洢
 * ����ȡ����
 * ֻ��֧��java.io.Serializable�ӿڵĶ������д������
 * ������ʲô�����л��ͷ����л���
 * ���л����Ѷ���ת��Ϊ�ֽ����еĹ��̳�Ϊ��������л���
 * �����л������ֽ����лָ�Ϊ����Ĺ��̳�Ϊ����ķ����л�
 * ���л���Ŀ�ģ���������г־ô洢���ߴ���
 * �����Ĭ�����л�����д�������࣬��ǩ���Լ����з�˲̬�ͷǾ�̬�ֶε�ֵ
 * <p>
 * ����ת��
 */
public class ObjectIO {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeObj();
//		readObj();
    }

    /**
     * д����
     *
     * @throws IOException
     */
    public static void writeObj() throws IOException {
        //�����ֽ����������
        OutputStream os = new FileOutputStream("e:/obj.txt");
        //����һ������д�����������----ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(os);
        //д����
        oos.writeObject(new User(13));
        //�ر���
        oos.close();
        os.close();
    }

    /**
     * ��ȡ����
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readObj() throws IOException, ClassNotFoundException {
        //�����ֽ�����������
        InputStream is = new FileInputStream("e:/obj.txt");
        //����һ�����Զ������������---ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(is);
        //��ȡ����
        User user = (User) ois.readObject();
        System.out.println(user.getAge());
        //�ر�������
        ois.close();
        is.close();
    }


}
