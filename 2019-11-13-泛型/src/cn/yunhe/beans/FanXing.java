package cn.yunhe.beans;

/**
 * ?����ͨ���
 * ��������ͷ����ϵ�ʹ��
 * ����ʹ�ã�
 * 1 ���Ե��ɸ����е�һ�����ԣ��������ֻ���ڸ�����ʹ��
 */
public class FanXing<A> {

    private int num;

    private A a;

    public static void main(String[] args) {

        FanXing<String> fanxing = new FanXing<>();
        fanxing.show("����");

        Fanxing2 fx = new Fanxing2();
        fx.show("����2");
    }

    public void show(A a) {//Object obj = "����";
        this.a = a;
        System.out.println(a);
    }
}


/**
 * �����ڷ�����
 * �����η��ĺ��棬����ֵ���͵�ǰ��
 */
class Fanxing2 {

    public <A> void show(A a) {
        System.out.println(a);
    }

    public <B> void show2(B b) {
        System.out.println(b);
    }

    public <BB> void show3(BB b) {
        System.out.println(b);
    }
}
