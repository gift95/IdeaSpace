package api;


import java.text.DateFormat;
import java.util.Date;

class Demo01 {
    /**
     * sadsa
     *
     * @param args
     */
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance();
        DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        String nowDate = df.format(date);
        System.out.println(nowDate);
        String nowDate1 = df1.format(date);
        System.out.println(nowDate1);
        System.out.println(date.getTime());
        System.out.println();

    }
}
