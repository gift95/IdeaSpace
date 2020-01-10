package cn.yunhe.Demo;

import cn.yunhe.beans.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        HashSet list = new HashSet();
        list.add(new User(15, "john"));
        list.add(new User(15, "john"));
        list.add(new User(15, "john"));
        list.add(new User(14, "john2"));
        list.add(new User(16, "john3"));
        list.add(123);
        list.add("123");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ("1".equals(it.next())) {
                //ConcurrentModificationException
                //coll.add(456);
                it.remove();
            }
        }
        System.out.println(list);
    }


    private static Set addMethod() {
        Set list = new HashSet();
        list.add(new User(15, "john"));
        list.add(new User(15, "john"));
        list.add(new User(14, "john2"));
        list.add(new User(16, "john3"));
//		list.add("123");
//		list.add("abc");
//		list.add("hun");
//		list.add(123);
//		list.add(456);
        return list;
    }
}
