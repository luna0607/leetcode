package google;

import java.util.Arrays;

/**
 * Created by Ariana on 2018/3/3.
 */
public class MinimumPartition {
       /*link:http://www.lintcode.com/en/problem/minimum-partition/
       *内存优化。只保留dp[0]和dp[1]两行
     * @param : the given array
     * @return: the minimum difference between their sums
     */
    public int findMin(int[] arr) {
        if(arr.length==2){
            return Math.abs(arr[0]-arr[1]);
        }
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        int[][] dp=new int[2][(sum / 2)+1];
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
                    dp[1][j]=max(dp[0][j],dp[0][j-arr[i]]+arr[i]);
                }else {
                    dp[1][j]=dp[0][j];
                }
            }
              for(int tmp=0;tmp<sum/2+1;tmp++){
                    dp[0][tmp]=dp[1][tmp];
                }
        }
        int max=0;
        for(int j=0;j<sum/2+1;j++){
            if(dp[1][j]>max){
                max=dp[1][j];
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
        int[] tmp={616,202,595,876,388,120,238,296};
        System.out.print(minimumPartition.findMin(tmp));
    }
}
