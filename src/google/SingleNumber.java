package google;

/**
 * Created by Ariana on 2018/3/3.
 */
public class SingleNumber {
        /**
         * link:http://www.lintcode.com/en/problem/single-number-iv/
         * 思路：判断第n位和第n+1位是否相同，n每次+2。第一个不同的nums[n]就是答案
     * @param nums: The number array
     * @return: Return the single number
     */
    public int getSingleNumber(int[] nums) {
        // Write your code here
        int length=nums.length;
        for(int i=0;i<length-1;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[length-1];
    }
}
