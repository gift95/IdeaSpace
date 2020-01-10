package cn.yunhe.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        filePrint("E:/HBuilderX");
    }

    public static void filePrint(String path) throws IOException {
        File file = new File(path);
        File[] fileArr = file.listFiles();
        if (fileArr != null) {
            for (File f : fileArr) {
                if (!f.isDirectory()) {
                    f.delete();
                } else {
                }
            }
        } else {
            file.delete();
        }
    }
}
