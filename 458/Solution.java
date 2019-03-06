public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if(nums.length == 0)
            return -1;
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            if(nums[m] == target)
                l = m;
            if(nums[m] > target)
                r = m;
            if(nums[m] < target)
                l = m;
        }
        if(nums[r] == target) return r;
        else if (nums[l] == target) return l;
        return -1;
    }
}