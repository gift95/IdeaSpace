package cn.yunhe.practice;

/**
 * �����Զ���һ���ַ������������+ѭ�����䷭ת�����γ�һ���µ��ַ���
 */
public class Practice {

    public static void main(String[] args) {

        String str = "hello world";
        method01(str);
    }

    /**
     * ͨ���ַ���ƴ�ӵ���ʽʵ��
     *
     * @param str
     */
    public static void method01(String str) {
        String newStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr = newStr + str.charAt(i);
        }
        System.out.println(newStr);
    }

    /**
     * ͨ���ַ�����ʵ��
     *
     * @param str
     */
    public static void method02(String str) {
        char[] ch = new char[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            ch[str.length() - 1 - i] = str.charAt(i);
        }
        System.out.println(new String(ch));
    }

    /**
     * �Զ������j��Ϊ�ַ�������±�
     *
     * @param str
     */
    public static void method03(String str) {
        char[] ch = new char[str.length()];
        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            ch[j] = str.charAt(i);
            j++;
        }
        System.out.println(new String(ch));
    }
}
