/**
 * Created by Ariana on 2018/1/10.
 */
public class chapter2 {

    public static void main(String[] args) {
        chapter2 chapter2 = new chapter2();

        /** 斐波那契数
         * 给定 1，返回 0
         * 给定 2，返回 1
         * 给定 10，返回 34
         */
        for (int i = 1; i < 10; i++) {
            System.out.println(chapter2.getFibonacci(i));
        }

        /** 单例
         * A a = A.getInstance();
         * A b = A.getInstance();
         *  a应该等于b
         */
        chapter2 a=chapter2.getInstance();
        chapter2 b=chapter2.getInstance();
        System.out.println(a==b);
    }

    /**
     * 获得第n个斐波那契数列的数字
     *
     * @param n 第n个
     * @return 第n个数字
     */
    private int getFibonacci(int n) {
        int start = 0;
        int start2 = 1;
        int node = 0;
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        for (int i = 2; i < n; i++) {
            node = start + start2;
            start = start2;
            start2 = node;
        }
        return node;
    }

    /**
     * *设计一个 getInstance 方法，对于给定的类，每次调用 getInstance 时，都可得到同一个实例
     *
     * @return chapter2实例
     */
    public static chapter2 chapter2 = new chapter2();

    public static chapter2 getInstance() {
        // write your code here
        return chapter2;
    }
}
