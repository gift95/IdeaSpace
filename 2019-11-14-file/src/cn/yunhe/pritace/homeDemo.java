package cn.yunhe.pritace;

import org.apache.log4j.Logger;

public class homeDemo {
    private static Logger log = Logger.getLogger(homeDemo.class);

    public static void main(String[] args) {

        try {
            int a = 1 / 0;

        } catch (Exception e) {
            log.error("helloworld");
        }
    }
}
