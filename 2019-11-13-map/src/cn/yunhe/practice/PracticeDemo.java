package cn.yunhe.practice;

import java.io.File;
import java.io.IOException;

public class PracticeDemo {
    public static void main(String[] args) {
        File f = new File("c:" + File.separator);
        String[] str = f.list();
        for (String filename : str) {
            System.out.println(filename);
        }
        try {
            f.createNewFile();
        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }

    }

}
