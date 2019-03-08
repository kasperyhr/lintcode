public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int l = 0;
        int r = nums.length - 1;
        if(nums[l] < nums[r]) return nums[l];
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            if(nums[m] < nums[nums.length - 1])
                r = m;
            else
                l = m;
        }
        if(l > 0 && nums[l] < nums[l - 1]) return nums[l];
        return nums[r];
    }
}