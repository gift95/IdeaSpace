package cn.yunhe.pritace;

public class TestDemo {

    public static void main(String[] args) {
        Item item = new Item();
//		Item item1 = new Item();
        Thread it1 = new Thread(item, "�ۻ�ԱA");
        Thread it2 = new Thread(item, "�ۻ�ԱB");
        it1.start();
        it2.start();


    }

}
