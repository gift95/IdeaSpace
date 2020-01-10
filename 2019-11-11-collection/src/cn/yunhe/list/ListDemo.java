package cn.yunhe.list;

import cn.yunhe.beans.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * ���	add(int index) addAll(int index,Collection coll)
 * �Ƴ�	remove(int index) removeAll(int index,Collection coll)
 * ��ȡ	get(int index)
 * �޸�	set(int index,Object obj)
 * ��ȡ 	subList(int fromIndex,int endIndex)
 * ����	listIterator()
 * <p>
 * ��ҵ��
 * ����һ���������Զ������ļ��ϡ��������������ݣ������ظ���
 * ��ȡ��ȥ�ظ�֮���Ԫ��
 */
public class ListDemo {

    public static void main(String[] args) {
        List list = addMethod();
        Collection coll = new ArrayList();
        coll.add("abc");
        list.removeAll(coll);
        System.out.println(list);
        //removeMethod();
        //subMethod();
        //listIterator();
        //pojoIterator();
    }

    /**
     * ���
     *
     * @return
     */
    public static List addMethod() {
        List list = new ArrayList();
        list.add("abc");
        list.add("abc");
        list.add("abc");
        list.add("bcd");
        list.add(1, 123);

        List list2 = new ArrayList();
        list2.add(456);
        list2.add("qwe");

        list.add(1, list2);
        return list;
    }

    /**
     * �Ƴ�
     */
    public static void removeMethod() {
        List list = addMethod();
        System.out.println("�Ƴ�ǰ�ļ��ϣ�" + list);
        //list.remove(2);
        System.out.println("��ȡҪɾ����ֵ��" + list.get(2));
        list.set(2, null);
        System.out.println("�Ƴ���ļ��ϣ�" + list);
    }

    /**
     * ��ȡ����
     */
    public static void subMethod() {
        List list = addMethod();
        System.out.println("��ȡǰ�ļ��ϣ�" + list);
        List subList = list.subList(0, 2);
        System.out.println("��ȡ��ļ��ϣ�" + subList);
        System.out.println("ԭ���ϣ�" + list);
    }

    /**
     * ����
     */
    public static void listIterator() {
        List list = addMethod();
        System.out.println("ԭ���ϣ�" + list);
        //��ȡ������
        ListIterator listIt = list.listIterator();
		/*System.out.print(listIt.next());
		System.out.print(listIt.next());
		System.out.println(listIt.next());
		
		System.out.println("-----");
		
		System.out.print(listIt.previous());
		System.out.print(listIt.previous());
		System.out.print(listIt.previous());*/
        //��ֵΪ123ʱ����������456����ֵΪabc�����޸�Ϊaaa
        while (listIt.hasNext()) {
            Object obj = listIt.next();
            if (obj.equals(123)) {
                listIt.add(456);
            }
            if ("abc".equals(obj)) {
                listIt.set("aaa");
            }
        }
        System.out.println(list);
    }

    /**
     * ����Զ�������
     */
    public static void pojoIterator() {
        List list = new ArrayList();
        list.add(new User(12, "juni"));
        list.add(new User(13, "juni2"));
        list.add(new User(14, "juni3"));
        list.add(123);

        ListIterator listIt = list.listIterator();
        while (listIt.hasNext()) {
            User user = null;
            Object obj = listIt.next();
            if (obj instanceof User) {
                user = (User) obj;
                if (user.getAge() > 12) {
                    System.out.println(user.getName());
                }
            }
        }
    }


}
