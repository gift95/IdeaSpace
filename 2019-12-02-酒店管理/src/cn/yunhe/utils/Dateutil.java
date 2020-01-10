package cn.yunhe.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateutil {
    /**
     * 将规定格式的字符串转换为Date类型的对象
     *
     * @param startTime
     * @return
     */
    public static Date strToDate(String startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date st = null;
        try {
            st = sdf.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return st;
    }

    /**
     * 获取入住的天数
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 天数
     */
    public double strInDate(String startTime, String endTime) {

        double result = 0;
        try {
            Date st = strToDate(startTime);
            Date et = strToDate(endTime);
            result = (st.getTime() - et.getTime()) / 1000f / 6f / 60f / 24f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
