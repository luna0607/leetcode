/**
 * Created by Ariana on 2018/1/10.
 */
public class fibonacci {
    /**
     * 给定 1，返回 0
     * 给定 2，返回 1
     * 给定 10，返回 34
     */
    public static void main(String[] args) {
        fibonacci fibonacci=new fibonacci();
        for(int i=1;i<10;i++){
                    System.out.println(fibonacci.getFibonacci(i));
        }
    }

    /**
     * 获得第n个斐波那契数列的数字
     *
     * @param n 第n个
     * @return 第n个数字
     */
    public int getFibonacci(int n) {
        int start = 0;
        int start2 = 1;
        int node = 0;
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }
        for (int i = 2; i < n; i++) {
            node = start + start2;
            start = start2;
            start2 = node;
        }
        return node;
    }
}
