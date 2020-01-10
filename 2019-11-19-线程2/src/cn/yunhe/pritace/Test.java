package cn.yunhe.pritace;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ThreadDemo td = new ThreadDemo(lock);
        ThreadDemo td1 = new ThreadDemo(lock);

        td.start();
        td1.start();

    }

}

