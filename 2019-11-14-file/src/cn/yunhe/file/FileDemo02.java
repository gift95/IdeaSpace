package cn.yunhe.file;

import java.io.File;
import java.text.DateFormat;

public class FileDemo02 {
    public static void main(String[] args) {
        showDir("E:/�½��ļ���/");
        showDir("E:/�½��ļ���/12.txt");

    }

    public static void showDir(String path) {
        File file = new File(path);
        DateFormat df = DateFormat.getDateTimeInstance();
        String nowDate = df.format(file.lastModified());
        System.out.println(nowDate);
    }
}
