package cn.yunhe.services;

import cn.yunhe.beans.Item;
import cn.yunhe.beans.Result;

import java.util.*;

public class ResultDemo {

    public static void main(String[] args) {
        Result result = new Result();
        List<Item> list = new ArrayList<>();
        //Item item1 = new Item(1, 12.3, "Highdog", "dog");
        Item item1 = new Item();
        list.add(item1);
        Iterator<Item> it = list.iterator();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listTable", list);
        if (item1.getName() != null) {
            result.success();
            result.setMap(map);
            System.out.println(list.size());
            System.out.println(result);
        } else {
            result.success();
            System.out.println(result.getMsg());
        }

    }


}
