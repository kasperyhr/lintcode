public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        // write your code here
        int[] ret = new int[nums.length];
        int prev = 1;
        ret[0] = 1;
        for(int i = 1; i < nums.length; i++){
            ret[i] = prev * nums[i - 1];
            prev = ret[i];
        }
        prev = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            ret[i] *= prev;
            prev *= nums[i];
        }
        return ret;
    }
}