package cn.yunhe.date;

import java.util.Calendar;

/**
 * 当需要单独获取年月日时分秒时，才会使用该类
 * 作业：
 * 需求：将时分秒的值在不满足10时变为0X显示
 */
public class CalendarDemo {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        //获取年
        int year = cal.get(Calendar.YEAR);
        //获取月份
        int month = cal.get(Calendar.MONTH) + 1;
        //获取月中的某一天
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //获取小时
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        //获取分钟数
        int minutes = cal.get(Calendar.MINUTE);
        //获取秒
        int seconds = cal.get(Calendar.SECOND);

        String time = year + "年" + month + "月" + day + "日" + hour + "时" + minutes + "分" + seconds + "秒";
        System.out.println("当前时间为:" + time);

        //获取明天的此刻时间
        cal.add(Calendar.DAY_OF_MONTH, 1);
        int tom = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(tom);
    }

}
