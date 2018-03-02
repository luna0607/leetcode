package google;

/**
 * Created by Ariana on 2018/3/3.
 */
public class FactorialDivide {
    /*
    link:http://www.lintcode.com/en/problem/last-digit-by-factorial-divide/
 * @param A: the given number
 * @param B: another number
 * @return: the last digit of B! / A!
 */
    public int computeLastDigit(long A, long B) {
        // write your code here
        if(A==B){
            return 1;
        }
        String AString = Long.toString(A);
        String BString = Long.toString(B);
        int lastA = Character.getNumericValue(AString.charAt(AString.length() - 1));
        int lastB = Character.getNumericValue(BString.charAt(BString.length() - 1));
        long count = B - A;
        if (count == 1) {
            return lastB;
        }
        //如果从1开始，就是1、2、6、4、0、0……
        //如果从2开始，就是2、6、4、0、0、0……
        //如果从3开始，就是3、2、0、0、0……
        //如果从4开始，就是4、0、0、0、0……
        //如果从5开始，就是5、0、0……
        //如果从6开始，就是6、2、6、4、0……
        //如果从7开始，就是7、6、4、0、0……
        //如果从8开始，就是8、2、0、0、0……
        //如果从9开始，就是9、0、0、0……
        //如果从0开始，就是0
        switch (lastA+1) {
            case 1:
            case 6:
                if(count>4){
                    return 0;
                }else if(count>3){
                    return 4;
                }else if(count>2){
                    return 6;
                }else {
                    return 2;
                }
            case 2:
            case 7:
                if(count>3){
                    return 0;
                }else if(count>2){
                    return 4;
                }else {
                    return 6;
                }
            case 3:
            case 8:
                if(count>2){
                    return 0;
                }else {
                    return 2;
                }
            case 4:
            case 5:
            case 9:
            case 0:
                return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        FactorialDivide factorialDivide = new FactorialDivide();
        long A = new Long("1234");
        long B = new Long("1239");
        System.out.println(factorialDivide.computeLastDigit(A, B));
    }
}
