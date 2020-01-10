package cn.yunhe.practice;

import java.util.ArrayList;
import java.util.List;

public class Practice {

    public static void main(String[] args) {

        List list = new ArrayList();

        list.add("abc");
        list.add("abc");
        list.add("123");
        list.add("321");
        list.add("aaaa");
        list.add("bbb");

        System.out.println("ԭʼ����:" + list);

        //�Լ���ȥ�ظ�
        //˼·������һ���¼��ϣ��жϸü������Ƿ�����һ��Ԫ�أ�ô�о���ӣ��оͷŹ�
        List newList = new ArrayList();
        for (Object obj : list) {
            if (!newList.contains(obj)) {
                newList.add(obj);
            }
        }
        System.out.println("ȥ�ظ�����¼��ϣ�" + newList);
    }
}
