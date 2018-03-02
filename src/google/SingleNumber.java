package google;

/**
 * Created by Ariana on 2018/3/3.
 */
public class SingleNumber {
        /**
         * link:http://www.lintcode.com/en/problem/single-number-iv/
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
