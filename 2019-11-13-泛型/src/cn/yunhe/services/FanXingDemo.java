package cn.yunhe.services;

import cn.yunhe.beans.Item;
import cn.yunhe.beans.Order;
import cn.yunhe.beans.Result;

import java.util.*;

/**
 * ���ͣ��㷺������
 * ������JDK1.5֮����ֵ�һ�ְ�ȫ����
 * һ������ָ����������
 * ��������Ϊĳһ������
 * �﷨��ʽ�������͵ĺ������<����>
 */
public class FanXingDemo {

    public static void main(String[] args) {
//		iteratorMethod();
//		iteratorMethod2();
		/*//��ȡ���ж����б�
		List<Order> orderList = (List<Order>) queryAll();
		//��ȡ��Ʒ�б�
		List<Item> itemList = (List<Item>) queryAll();*/

        Result result = query();
        System.out.println("��������" + result);
    }

    /**
     * ԭʼ����
     */
    public static void iteratorMethod() {
        List list = new ArrayList();
        list.add("�����ַ���");
        list.add(new Order(10234567, "֣���и�����"));
        list.add(new Order(23456745, "֣���н�ˮ��"));

        //��ȡ����������
        Iterator it = list.iterator();
        //����
        while (it.hasNext()) {
            //���ж�����
            Object obj = it.next();
            if (obj instanceof Order) {
                //�������еĵ�ַ����ӡ����
                Order order = (Order) obj;
                System.out.println("��ַΪ��" + order.getAddress());
            }
        }
    }

    /**
     * �޶����ʹ����ĺô���
     * 1 ���쳣������ʱ�쳣����ǰ���˱���ʱ�쳣
     * 2 ���ٴ�����������˴���Ľ�׳��
     */
    public static void iteratorMethod2() {
        //jdk1.7����ǰҪ�����ķ��ͱ����о������ͣ�1.8֮�󣬿ɲ�д
        List<Order> list = new ArrayList<>();
        //list.add("�����ַ���");
        list.add(new Order(10234567, "֣���и�����"));
        list.add(new Order(23456745, "֣���н�ˮ��"));

        //��ȡ����������
        Iterator<Order> it = list.iterator();
        //����
        while (it.hasNext()) {
			/*//���ж�����
			Object obj = it.next();
			if(obj instanceof Order){
				//�������еĵ�ַ����ӡ����
				Order order = (Order)obj;
				System.out.println("��ַΪ��"+order.getAddress());
			}*/
            Order order = it.next();
            System.out.println(order.getAddress());
        }
    }

    /**
     * ��ѯ���еĶ����б�
     *
     * @return
     */
    public static List<Order> queryOrderList() {
        //�������ݿ��ȡ��Ӧ������
        //�˴�Ϊģ�����---ֱ�Ӷ���һ������
        List<Order> orderList = new ArrayList<>();
        return orderList;
    }

    /**
     * ��ѯ���е���Ʒ��Ϣ�б�
     *
     * @return
     */
    public static List<Item> queryItemList() {
        List<Item> itemList = new ArrayList<>();
        return itemList;
    }

    /**
     * ?����ͨ���
     *
     * @return
     */
    public static List<?> queryAll() {
        List<?> objList = new ArrayList<>();
        return objList;
    }

    /**
     * result�з�װ����Ҫ���ص�����
     *
     * @return
     */
    public static Result query() {
        Result result = new Result();
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(123, 111.11, "����dog", "dog"));
        result.setCode(200);
        result.setMsg("success");
        result.setCount(itemList.size());
        Map<String, Object> map = new HashMap<>();
        map.put("itemList", itemList);
        result.setMap(map);
        return result;
    }
}
