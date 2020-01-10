package api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڹ�����
 */
public class DateUtil {

    private static DateFormat dateFormat = null;
	/*private static final String TIME_ROLE = "yyyy-MM-dd HH:mm:ss";
	
	static{
		dateFormat = new SimpleDateFormat(TIME_ROLE);
	}*/

    /**
     * �������ַ���ת��Ϊdate����
     *
     * @param time     Ҫת����ʱ��
     * @param timeRole ת������
     * @return ����һ��date���͵����ڶ���
     * @throws ParseException �����ڸ�ʽ��һ��ʱ�׳����쳣
     */
    public static Date strToDate(String time, String timeRole) throws ParseException {
        dateFormat = new SimpleDateFormat(timeRole);
        return dateFormat.parse(time);
    }

    /**
     * �������ַ���ת��Ϊlong��ֵ
     *
     * @param time
     * @param timeRole
     * @return
     * @throws ParseException
     */
    public static long strToLong(String time, String timeRole) throws ParseException {
        Date date = strToDate(time, timeRole);
        long timeLong = date.getTime();
        return timeLong;
    }

    /**
     * ������������֮����������
     *
     * @param time1
     * @param time2
     * @param timeRole
     * @return
     * @throws ParseException
     */
    public static double compareDate(String time1, String time2, String timeRole) throws ParseException {
        long timeLong1 = strToLong(time1, timeRole);
        long timeLong2 = strToLong(time2, timeRole);

        double day = (timeLong1 - timeLong2) / 1000.0 / 60 / 60 / 24;
        return Math.abs(day);
    }
}
