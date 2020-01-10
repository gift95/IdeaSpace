package cn.yunhe.Ioliu;

import cn.yunhe.beans.Item;

import java.io.*;

public class ObjectIO {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO 自动生成的方法存根
        objWrite();
        objReader();
    }

    public static void objWrite() throws IOException {
        OutputStream file = new FileOutputStream("e:/b.txt");//OBjectOutputStream内的文件类型是OutputStream
        ObjectOutputStream oos = new ObjectOutputStream(file);
        oos.writeObject(new Item(1, 2, 3, "暖手宝", "郑州市"));
        oos.close();
        file.close();

    }

    public static void objReader() throws IOException, ClassNotFoundException {
        InputStream file = null;
        ObjectInputStream ois = null;
        try {
            file = new FileInputStream("e:/c.txt");

            ois = new ObjectInputStream(file);
            Item item = (Item) ois.readObject();
            System.out.println(item.getName());
        } catch (Exception e) {
            System.exit(0);

        } finally {
            ois.close();
            file.close();
        }
    }
}
