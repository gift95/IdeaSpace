package cn.yunhe.set;

import java.util.Comparator;

public class CompareByName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Person2 p1 = (Person2) o1;
        Person2 p2 = (Person2) o2;
        return p1.getName().compareTo(p2.getName());
    }

}
