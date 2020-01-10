package cn.yunhe.map;

import java.util.HashMap;

public class MapDemo {

    public static void main(String[] args) {
        //���裺������ͬ������Ҳ��ͬ������ͬһ������
        HashMap map = new HashMap();
        map.put(new User(13, "С��"), "123");
        map.put(new User(13, "С��"), "123");
        map.put(new User(14, "С��2"), "123");
        map.put(new User(15, "С��3"), "123");

        System.out.println(map);

    }
}
