package google;

import java.util.Arrays;

/**
 * Created by Ariana on 2018/3/3.
 */
public class MinimumPartition {
       /*link:http://www.lintcode.com/en/problem/minimum-partition/
     * @param : the given array
     * @return: the minimum difference between their sums
     */
    public int findMin(int[] arr) {
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        int[][] dp=new int[arr.length][(sum / 2)+1];
        for(int j=0;j<sum/2+1;j++){
            if(arr[0]<=j){
                dp[0][j]=arr[0];
            }else{
                dp[0][j]=0;
            }
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<sum/2+1;j++){
                if(j>=arr[i]){
                    dp[i][j]=max(dp[i-1][j],dp[i-1][j-arr[i]]+arr[i]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int max=0;
        for(int j=0;j<sum/2+1;j++){
            if(dp[arr.length-1][j]>max){
                max=dp[arr.length-1][j];
            }
        }
        return Math.abs(sum-max-max);
    }

    private int max(int i, int i1) {
        if(i>i1){
            return i;
        }else {
            return i1;
        }
    }

    public static void main(String[] args) {
        MinimumPartition minimumPartition=new MinimumPartition();
        int[] tmp={1,6,11,5};
        System.out.print(minimumPartition.findMin(tmp));
    }
}
