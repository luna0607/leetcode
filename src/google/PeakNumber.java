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
        int left=0;
        int right=A.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(A[mid]>A[mid+1]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return right;
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
