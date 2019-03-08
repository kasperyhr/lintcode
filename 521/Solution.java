public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        int ptr = 0;
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!s.contains(nums[i])){
                s.add(nums[i]);
                nums[ptr++] = nums[i];
            }
        }
        return ptr;
    }
}