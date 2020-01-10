package cn.yunhe.list;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo01 {
    public static void main(String[] args) {
        Map map = new HashMap<String, String>();
        map.put("bookName", "java oop");
        map.put("author", "john");
        map.put("price", 50);//�Զ�װ��
        map.put("price", 80);//�����ظ��ļ�:price
        map.put(null, "nothing");//�ռ�
        System.out.println(map.get("author"));//ȡ����Ϊ��author����ֵ��john��
        Collection col = map.values();//ȡ��Map��ȫ����value
        System.out.println(col);
        Set keySet = map.keySet();  //ȡ��Map�м�����
        System.out.println(keySet);

    }
}
