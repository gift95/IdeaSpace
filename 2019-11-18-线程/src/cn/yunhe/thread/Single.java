package cn.yunhe.thread;

public class Single {

    private static Single single;

    private Single() {
    }

    /**
     * 返回当前类的实例对象
     * 需要的时候才创建该对象
     *
     * @return
     */
    public static Single newInstance() {
        if (single == null) {
            synchronized (Single.class) {
                //判断对象是否已创建
                if (single == null) {
                    //睡眠操作
                    single = new Single();
                }
            }
        }
        return single;
    }
}

class Single2 {

    private static Single2 single = new Single2();

    private Single2() {
    }

    public static Single2 newInstance() {
        return single;
    }
}


