package cn.yunhe.string;

import java.io.UnsupportedEncodingException;

/**
 * char代表字符
 * String代表字符串
 * String是有多个char组成
 * 字符串中用的是length属性还是length方法？
 * 	字符串是length()，数组是length属性
 * 1、字符串是不可变的量
 * 2、==用于判断地址，通常用于引用数据类型的判断
 * 	基本数据类型使用==判断值是否相同
 * 3、==和equals的区别
 * 	==用于比较基本数据类型，equals用于比较值是否相同----这句话不严谨
 *  ==比较基本数据类型时比较的是值是否相同，比较引用数据类型时比较的是地址是否相同，
 *  在String中的equals方法先比较地址是否相同，不相同时再比较值是否相同
 */
public class StringDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "abc";
		//该行代码创建了几个对象--两个 
		String str2 = new String("aaaaa");
		System.out.println(str2);
		
		String str3 = "hello";
		String str4 = "world";
		String str5 = "helloworld";
		String str6 = str3 + str4;
		System.out.println(str5 == str6);
		
		byte[] bytes = {1,2,3,4,5,6};
		char[] chars = {'a','b','c'};
		System.out.println(new String(chars));
		
		//charAt(int index)获取指定索引出的下标
		System.out.println(str5.charAt(1));
		//codePointAt(int index)返回指定索引出的Unicode值
		System.out.println(str5.codePointAt(1));
		//indexOf(int ch)返回指定字符对应的下标
		System.out.println(str5.indexOf('l'));
		System.out.println(str5.lastIndexOf('l'));
		//isEmpty()判断字符串是否为空
//		String str7 = null;
		String str7 = " ";
		System.out.println(str7.isEmpty());
		//length()获取字符串的长度
		System.out.println("str5的长度为："+str5.length());
		//截取元素---将str5中的world单独截取出来
		int startIndex = str5.indexOf("world");
		//结束下标
		int endIndex = str5.length()-1;
		//包含开始不包含结束
		System.out.println(str5.substring(startIndex, str5.length()));
		//split()分割
		String str9 = "http://www.baidu.com";
		String[] strArr = str9.split("\\.");
		/*for(String str : strArr){
			System.out.println(str);
		}*/
		for(int i=0;i<strArr.length;i++){
			System.out.println(strArr[i]);
		}
		
		int num = 123;
		System.out.println(String.valueOf(num).length());
		
		equalsMethod(str5,str6);
	}
	
	/**
	 * equals方法判断两个字符串的值是否相等
	 */
	public static void equalsMethod(String str1,String str2){
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
	}
	
	
	
	
}
