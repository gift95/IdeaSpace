package cn.yunhe.date;

import java.util.Date;

public class DateDemo {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        //��ȡ��ǰʱ��ĺ���ֵ
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());

        //�����ڵ��Ⱥ�˳��Ƚ� 1573108275963
        Date oldDate = new Date(1573108275963L);
        System.out.println(date.after(oldDate));
        System.out.println(date.before(oldDate));
        System.out.println(date.compareTo(oldDate));
    }
}
