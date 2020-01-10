package cn.yunhe.map;

import cn.yunhe.beans.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map
 */
public class MapDemo {

    public static void main(String[] args) {
//		test();
        Map map = getProducts();
        System.out.println(map);
    }

    public static void test() {
        Map map = new HashMap();
		/*User user = new User(12,"aaa");
		map.put(user,"12312313");
		System.out.println(map.get(user));*/
    }

    /**
     * ���󣺷�����Ʒ�б�����״̬
     * code:200	404 500
     * msg:"success"/"fail"
     * count:12
     * productList:"{}"
     */
    public static Map getProducts() {
        //�洢���ݵļ���
        List<User> userList = new ArrayList();
        userList.add(new User(16, "С��"));
        userList.add(new User(19, "����"));
        userList.add(new User(18, "СС��"));

        //����״̬��
        int code = 200;
        //����״̬��Ϣ
        String msg = "success";
        //�������������
        int count = userList.size();

        //���������ݴ洢��map�����в�����
        Map map = new HashMap();
        map.put("code", code);
        map.put("msg", msg);
        map.put("count", count);
        map.put("userList", userList);

        return map;
    }
}
