package cn.yunhe.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

    public static void main(String[] args) throws ParseException {
        //������ת��Ϊyyyy-MM-dd HH:mm:ss
        DateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
        String time = df.format(new Date());
        System.out.println(time);

        //parse����--�������ַ���ת��Ϊdate
        String date = "2019��11��07�� 12:02:10";
        System.out.println(df.parse(date));
    }
}
