package cn.yunhe.beans;

import cn.yunhe.practice.CompareByAgeAndName;

import java.util.TreeSet;

public class Test extends CompareByAgeAndName {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add("nba");

        set.add("����");
        set.add("����");
        set.add("����");
        System.out.println(set);
    }


}
