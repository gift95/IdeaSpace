package cn.yunhe.fx;

import cn.yunhe.beans.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射：通过指定的路径来获取对应class文件中的所有的可操作的属性和方法
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
//		getClassObj();
//		getClassObjAll();
//		getClassMethods();
//		getClassAllMethods();
//		getCls();
        getCls2();
    }

    /**
     * 通过反射来获取class文件中的属性和方法
     * 需要给定要读取的文件的包名+文件名
     * 所有的引用数据类型和基本数据类型都有class属性
     *
     * @throws Exception
     */
    public static void getCls2() throws Exception {
        //通过反射获取到了class文件的对象
        Class<User> cls = (Class<User>) Class.forName("cn.yunhe.beans.User");
        //目的：获取一个age和name的构造器来创建对象 new User(12,"小射");
        Constructor<User> con = cls.getConstructor(int.class, String.class);
        User user = con.newInstance(12, "小射");
        System.out.println(user.getName());
    }

    /**
     * 通过反射来获取class文件中的属性和方法
     * 需要给定要读取的文件的包名+文件名
     *
     * @throws Exception
     */
    public static void getCls() throws Exception {
        //通过反射获取到了class文件的对象
        Class<User> cls = (Class<User>) Class.forName("cn.yunhe.beans.User");
        //获取文件中的构造器和其他方法
        Constructor<User>[] cons = (Constructor<User>[]) cls.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        //已经知道该类中有哪些构造器及对应的参数
        //根据已知的构造器来获取对象
        User user = cls.newInstance();
        user.setName("小张");
        System.out.println(user.getName());
    }


    /**
     * 假设是通过反射获取到的class文件对象
     * 获取公共的构造器
     */
    public static void getClassObj() {
        //获取User的class文件
        Class<User> cls = User.class;
        //获取公共的构造器数组
        Constructor[] cons = cls.getConstructors();
        //遍历数组获取对应的构造器信息
        for (Constructor con : cons) {
            System.out.println(con);
        }
    }

    /**
     * 假设是通过反射获取到的class文件对象
     * 获取所有的构造器
     */
    public static void getClassObjAll() {
        //获取User的class文件
        Class<User> cls = User.class;
        //获取公共的构造器数组
        Constructor[] cons = cls.getDeclaredConstructors();
        //遍历数组获取对应的构造器信息
        for (Constructor con : cons) {
            System.out.println(con);
        }
    }

    /**
     * 获取指定类的所有公共方法
     */
    public static void getClassMethods() {
        //获取User的class文件
        Class<User> cls = User.class;
        //获取该class文件中的所有公共方法
        Method[] methods = cls.getMethods();
        //遍历获取方法的信息
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * 获取指定类的所有的方法
     */
    public static void getClassAllMethods() {
        //获取User的class文件
        Class<User> cls = User.class;
        //获取该class文件中的所有公共方法
        Method[] methods = cls.getDeclaredMethods();
        //遍历获取方法的信息
        for (Method method : methods) {
            System.out.println(method);
        }
    }

}
