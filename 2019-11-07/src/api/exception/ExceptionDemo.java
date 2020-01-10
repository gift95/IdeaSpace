package api.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Throwable
 * ����---error
 * �޷�ͨ��������������
 * �ڴ����
 * �쳣---exception
 * �����ڱ����ִ��ʱ�ڳ��ֵ�δ֪���
 * <p>
 * �����ļ����쳣
 * NullPointerException
 * IndexOutOfBoundsException
 * ClassCastException
 * ParseException
 * NumberFormatExcetion
 * <p>
 * ΪʲôҪ�����쳣��
 * ���ڳ�����ֵ��쳣�������������ô����ͽ����ˣ���������ִ��
 * �����쳣��������ʽ
 * ��ʽһ���׳�
 * ΪʲôҪ�׳���ʲô�������Ҫ�׳�������
 * ��һ�֣�jdk�Դ�����Ҫ�׳����쳣	ParseException	FileNotFoundException...
 * �ڶ��֣������ֵ��쳣��Ҫ�����ߴ���ʱ���Ǿ��׳�
 * throw throws
 * throw�������׳��쳣�ģ�throws�����������쳣��
 * throw���ڷ�����ʹ�õģ�throws���ڷ�������ʹ�õ�
 * ���Ҫʹ��throws��������쳣���м䶺�Ÿ���
 * ��ʽ��������
 * <p>
 * try��д���ǿ��ܻ�����쳣�Ĵ���
 * catch��д���Ƕ�Ӧ���쳣�Ĵ�����
 * finally���������Ƿ�����쳣����Ȼ��ִ�еĴ���
 * ex:���Ĺر�	���ݿ����Ӷ���Ĺرղ���
 * <p>
 * try{}catch(�쳣���� ����){������}...finally{}
 * 1��try��catch��finally���ܵ������ڣ�ʹ��һ����try+���е�����һ������
 * 2�����ж���쳣ʱ������ʹ�ö��catch���д���
 * 3����Χ�ϴ���쳣��Ҫ��������棨ͨ��˵�Ķ���Exception��
 * <p>
 * final finally finalize
 * �Զ����쳣���ʵ��
 * 1������Ҫ���п�����---�̳��쳣��ϵ
 */
public class ExceptionDemo {

    public static void main(String[] args) throws MyException, ParseException {

        String[] strArr = {"С��", "С��", "С��", "С��"};
//		String[] strArr = null;
        /*printArr(strArr);*/

        printArr3(strArr, 10);
        System.out.println("--over--");
    }

    public static void printArr3(String[] strArr, int index) {
        try {
            int length = strArr.length;
            String sss = strArr[index];
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            //System.out.println("����ָ���쳣");
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("��Ȼ��ִ�еĴ���");
        }
    }

    public static void printArr2(String[] strArr, int index) throws MyException, NullPointerException, ParseException {
        new SimpleDateFormat().parse("");

        if (index == 3) {
            throw new MyException("�Զ����쳣");
        }
        if (null == strArr) {
            throw new NullPointerException("����£�����ĿǰΪ��");
        }
        if (index >= strArr.length) {
            throw new ArrayIndexOutOfBoundsException("�����±곬���˷�Χ��" + index);
        }
    }

    /**
     * ���ܣ����Ա���ָ�����ַ�������
     *
     * @param strArr
     */
    public static void printArr(String[] strArr) {
        if (null != strArr) {//if(strArr != null){}
            for (int i = 0; i < strArr.length; i++) {
                System.out.println(strArr[i]);
            }
        }
    }


}







