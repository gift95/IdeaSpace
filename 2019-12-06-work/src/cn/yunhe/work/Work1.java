package cn.yunhe.work;

public class Work1 {
    public static void main(String[] args) {
        int[] arr = {15, 26, 78, 45, 1, 57, 32, 5, 42};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    //如果j+1的值大于j的值 他们两个互换位置 大的在最前
                    int mid = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = mid;
                }

            }

        }
        //输出数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }

}
