package api.exception;

import org.apache.log4j.Logger;

/**
 * ��һ������Ŀ�ĸ�Ŀ¼�´���lib�ļ��У���log4j��jar�����ƽ���
 * �ڶ�����jar���Ҽ�build path-->add build path
 * ��������src�ĸ����½�log4j�������ļ����ؽ���
 * ���ģ������л�ȡ��Ӧ��logger�������ʹ��
 */
public class Log4jDemo {

    //	private static Logger log = Logger.getLogger("Log4jDemo");
    private static Logger log = Logger.getLogger(Log4jDemo.class);

    public static void main(String[] args) {

        try {
            int a = 1 / 0;

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
