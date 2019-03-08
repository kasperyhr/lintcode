public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr2 < nums.length){
            if(nums[ptr2] != 0){
                swap(nums, ptr1++, ptr2);
            }
            ptr2++;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}