package cn.yunhe.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * ��Ҫ���ã�
 * ��һ�������ڽ��и�ʽ��
 * �����ڰ�ָ���ĸ�ʽת��Ϊ�ַ���
 * �ڶ����������ַ���ת��ΪDate����
 */
public class DateFormatDemo {

    public static void main(String[] args) throws ParseException {
        //��ȡ��ǰʱ��
        Date date = new Date();
        //����ʽ��ȡ������ֻ�������յĶ���
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        //��ʽ����ǰʱ��
        String nowDate = df.format(date);
        System.out.println(nowDate);

        //��ȡ������ʱ����Ķ���
        DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT);
        String nowDate2 = df2.format(date);
        System.out.println(nowDate2);

        //�������ַ���ת��Ϊdate����
        String time = "2019-11-7";
        Date dd = df.parse(time);
        System.out.println(dd);
    }
}
