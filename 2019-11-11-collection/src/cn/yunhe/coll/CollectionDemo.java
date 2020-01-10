package cn.yunhe.coll;

import cn.yunhe.beans.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ���飺
 * �ŵ㣺���ҿ�
 * ȱ�㣺��ɾ�������ȹ̶�������Ψһ
 * ����	--	����
 * ���ȿɱ䡢���Ϳɲ�Ψһ�������е�Ԫ�ض���������������
 * <p>
 * Collection
 * �ص㣺
 * �ظ��Ͳ����ظ�
 * ���������
 * ������
 * ���	add(Object obj)	add(Collection coll)
 * �Ƴ�	remove(Object obj)	removeAll(Collection coll) clear()
 * �ж�	isEmpty()	contains(Object obj)	containsAll(Collection coll) size()
 * ������	iterator()
 * ת��	toArray()
 * �����ࣺ
 * Arrays	Collections
 * <p>
 * List
 * �����ҿ��ظ�
 * ArrayList
 * LinkedList
 * Set
 * �����Ҳ����ظ�
 * HashSet
 * TreeSet
 */
public class CollectionDemo {

    public static void main(String[] args) {
        //addMethod();
        //removeMethod();
        //containsMethod();
        //iteratorMethod();
        iteratorMethod2();
    }

    /**
     * ���
     */
    public static Collection addMethod() {
        //����һ�����϶���
        Collection coll = new ArrayList();
        coll.add(1);
        coll.add("abc");
        coll.add(new User(12, "juni"));

        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(1);

        coll.addAll(coll2);

        //System.out.println(coll);
        return coll;
    }

    /**
     * �Ƴ�
     */
    public static void removeMethod() {
        //��ȡ���϶���
        Collection coll = addMethod();
        System.out.println("�Ƴ�ǰ�ļ��ϣ�" + coll + ",�Ƴ�ǰ���ϵĴ�С��" + coll.size());
		/*coll.remove("abc");
		coll.remove(1);
		System.out.println("�Ƴ���ļ��ϣ�"+coll);*/

        Collection coll2 = new ArrayList();
        coll2.add(1);
        coll2.add(123);
        coll2.add(456);

        coll.removeAll(coll2);
        System.out.println("�Ƴ���ļ��ϣ�" + coll + ",�Ƴ��󼯺ϵĴ�С��" + coll.size());
        coll.clear();
        System.out.println("��պ�ļ��ϣ�" + coll + ",��պ󼯺ϵĴ�С��" + coll.size());
        System.out.println("�ж϶����Ƿ�Ϊnull��" + (coll == null));
        System.out.println("�жϼ����Ƿ�Ϊ�գ�" + coll.isEmpty());
    }

    /**
     * �Ƿ����
     */
    public static void containsMethod() {
        Collection coll = addMethod();

        System.out.println("�жϼ������Ƿ��������1��" + coll.contains(1));
        System.out.println("�жϼ������Ƿ�����ַ���abcd��" + coll.contains("abcd"));
        System.out.println("�жϼ������Ƿ�����ַ���a��" + coll.contains("a"));

        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(466);

        System.out.println("�ж��Ƿ����ָ�����ϣ�" + coll.containsAll(coll2));

        Object[] objArr = coll.toArray();
        for (Object obj : objArr) {
            System.out.println(obj);
        }
    }

    /**
     * ������
     */
    public static void iteratorMethod() {
        Collection coll = addMethod();
        //��ȡ���ϵĵ���������
        //Iterator it = coll.iterator();
		/*//��ȡԪ��
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());*/

        //���ж��Ƿ���Ԫ��
		/*while(it.hasNext()){
			System.out.println(it.next());
		}*/
        for (Iterator it = coll.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }

    /**
     * ���������д��ڵ�����
     * ����ǰԪ��Ϊabcʱ�������������µ�Ԫ��456
     */
    public static void iteratorMethod2() {
        Collection coll = addMethod();
        Iterator it = coll.iterator();
        while (it.hasNext()) {
            if ("abc".equals(it.next())) {
                //ConcurrentModificationException
                //coll.add(456);
                it.remove();
            }
        }
        System.out.println(coll);
    }


}
