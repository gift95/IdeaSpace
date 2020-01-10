package cn.yunhe.set;

import java.util.HashSet;
import java.util.Set;

/**
 * set	�����ظ�������
 * HashSet
 * �ڲ����ݽṹ�ǹ�ϣ��
 * TreeSet
 * �ڲ����ݽṹ�Ǻ����
 */
public class SetDemo {

    public static void main(String[] args) {
        //addMethod();
        test();
    }

    public static void addMethod() {
        Set set = new HashSet();
        set.add("hello");
        set.add("world");
        set.add("hi");
        set.add("china");
        set.add("hello");
        set.add(null);
        set.add(null);

        System.out.println(set);
    }


    /**
     * ���裺���ֺ�������ͬ����ͬһ����(ͬһ������)
     */
    public static void test() {
        Set set = new HashSet();
        set.add(new User(12, "Juni"));
        set.add(new User(12, "Juni"));
        set.add(new User(12, "Juni1"));
        set.add(new User(12, "Juni2"));
        System.out.println(set);
    }


}
