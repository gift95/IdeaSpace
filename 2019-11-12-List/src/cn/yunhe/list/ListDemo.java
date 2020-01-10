package cn.yunhe.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


/**
 * List
 * <p>
 * ���ظ�������
 * <p>
 * ArrayList	��ͬ��	�ڲ�ά������һ����������ݽṹ
 * ��ѯ��
 * LinkedList	��ͬ��	�ڲ���һ���������ݽṹ
 * ��ɾ��
 */
public class ListDemo {

    public static void main(String[] args) {
        addMethod2();
        Collection coll = new ArrayList();
        coll.add("a");


    }

    public static void addMethod() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
    }

    public static void addMethod2() {
        LinkedList list = new LinkedList();
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("d");
        list.addFirst("e");
        System.out.println(list);

        System.out.println("��������ɾ����" + list.peekFirst());
        System.out.println("������ļ��ϣ�" + list);
        System.out.println("������ɾ����" + list.pollFirst());
        System.out.println("������ļ��ϣ�" + list);
    }
}
