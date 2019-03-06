public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            if(m > 0 && nums[m - 1] > nums[m])
                r = m;
            else if(m < nums.length - 1 && nums[m] < nums[m + 1])
                l = m;
            else
                l = m;
        }
        if(l < nums.length - 1 && nums[l] > nums[l + 1]) return nums[l];
        return nums[r];
    }
}