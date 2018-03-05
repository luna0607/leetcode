package google;

/**
 * Created by Ariana on 2018/3/5.
 */
public class PeakNumber {
      /*
      link:http://www.lintcode.com/en/problem/find-peak-element/
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A.length<3){
            return -1;
        }
        if(A.length==3){
            return 1;
        }
        int half=A.length/2;
        if(A[half]>A[half+1]){
            for(int i=half;i>0;i--){
                if(A[i]>A[i-1]){
                    return i;
                }
            }
        }else {
            for(int i=half;i<A.length-1;i++){
                 if(A[i]>A[i+1]){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A=new int[100001];
        for(int i=0;i<100000;i++){
            A[i]=i;
        }
        A[100000]=1;
        PeakNumber peakNumber=new PeakNumber();
        System.out.print(peakNumber.findPeak(A));
    }
}
