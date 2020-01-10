package cn.yunhe.treemap;

import cn.yunhe.beans.User;

import java.util.TreeMap;

/**
 * TreeMap
 * �ײ�ʹ�ú���������ݽṹ
 * �����Զ��������ʹ��ʱ��Ҫ�����Ƚ�������ΪTreeMapĬ��ʹ�õ�����Ȼ˳��Ƚ�����ֻ�������ַ����ͻ�����������(��װ��)
 * ��treeMap��Ĭ���Ǹ���keyֵ��������
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap map = new TreeMap();
		/*map.put("user1", new User(12,"С��"));
		map.put("auser2", new User(13,"����"));
		map.put("user3", new User(10,"����2"));*/

        map.put(new User(12, "С��"), "user1");
        map.put(new User(13, "����"), "user2");
        map.put(new User(10, "����2"), "user3");
        map.put(new User(10, "С��"), "user1");
        map.put(new User(10, "С��"), "user1");
        System.out.println(map);
    }
}
