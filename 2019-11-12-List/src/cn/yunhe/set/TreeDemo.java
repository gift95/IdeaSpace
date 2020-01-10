package cn.yunhe.set;

import java.util.TreeSet;

/**
 * TreeSet
 * ������--->ƽ�������--->�����
 * <p>
 * ��treeSet��Ԫ��Ĭ�ϰ���Ȼ˳���������
 * <p>
 * ��ҵ��
 * 1 ������ͬ�Ͱ���������
 * 2 �������ĳ�������
 */
public class TreeDemo {

    public static void main(String[] args) {
//		test();
        //pojo();
//		pojo2();
        pojo3();
    }

    /**
     * ���pojo���͵�����
     */
    public static void test() {
        TreeSet set = new TreeSet();
		/*set.add("3cba");
		set.add("1acb");
		set.add("2abc");
		set.add("bca");
		set.add("nba");*/

        set.add("����");
        set.add("����");
        set.add("����");
        System.out.println(set);
    }

    /**
     * �洢�Զ�������
     */
    public static void pojo() {
        TreeSet set = new TreeSet();
        set.add(new Person(32));
        set.add(new Person(12));
        set.add(new Person(3));
        set.add(new Person(42));
        set.add(new Person(38));

        System.out.println(set);
    }

    /**
     * ���������������
     */
    public static void pojo2() {
        TreeSet set = new TreeSet(new CompareByAge());
        set.add(new Person2(32));
        set.add(new Person2(12));
        set.add(new Person2(3));
        set.add(new Person2(42));
        set.add(new Person2(38));

        System.out.println(set);
    }

    /**
     * ����������������
     */
    public static void pojo3() {
        TreeSet set = new TreeSet(new CompareByName());
        set.add(new Person2("bca"));
        set.add(new Person2("asdsa"));
        set.add(new Person2("weijrhiwoe"));
        set.add(new Person2("hscusd"));
        set.add(new Person2("qwewd"));

        System.out.println(set);
    }

}
