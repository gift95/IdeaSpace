package cn.yunhe.interger;

/**
 * byte				Byte
 * short			Short
 * char 			Character
 * int				Integer
 * float			Float
 * double			Double
 * boolean			Boolean
 * long				Long
 * 第一：字符串和数字之间的类型转换
 * 第二：Integer中的数值范围问题
 * <p>
 * 常见的异常
 * NumberFormatException
 * NullPointerException
 * IndexOutOfException
 * ClassCaseException
 */
public class IntegerDemo {

    public static void main(String[] args) {

        //数字转字符串 方式一
        String.valueOf(123);
        //数字转字符串 方式二
        String str = 123 + "";
		
		/*char a = 'a';
		System.out.println(1 + (a + "abc"));
		System.out.println("abc" + a + 1);*/

        //字符串转数字 若值为null 则报错NumberFormatException 数字格式化异常
        Integer.valueOf("235");

        Integer in = new Integer(123);

        //将数字用Integer接收时，是装箱过程
        int in1 = 123;
        //将integer类型的值进行运算或者直接赋值给int类型叫拆箱
        int in2 = in1;

        int in3 = 127;
        Integer in4 = new Integer(127);
        Integer in5 = new Integer(127);
        System.out.println(in3 == in4);
        System.out.println(in5 == in4);
        System.out.println(in4.equals(in5));

        int in6 = 128;
        Integer in7 = 128;
        Integer in8 = new Integer(128);
        System.out.println(in6 == in7);
        System.out.println(in7 == in8);
        System.out.println(in7.equals(in8));

        System.out.println(Integer.MAX_VALUE);
    }
}
