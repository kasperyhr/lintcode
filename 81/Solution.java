public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        int[] ret = new int[nums.length];
        PriorityQueue<Integer> s = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> l = new PriorityQueue<Integer>();
        for(int i = 0; i < nums.length; i++){
            insert(nums[i], s, l);
            balance(s, l);
            ret[i] = s.peek();
        }
        return ret;
    }
    
    private void insert(int num, PriorityQueue<Integer> s, PriorityQueue<Integer> l){
        if(s.size() == 0 || num <= s.peek())
            s.offer(num);
        else
            l.offer(num);
    }
    
    private void balance(PriorityQueue<Integer> s, PriorityQueue<Integer> l){
        while(s.size() < l.size()){
            s.offer(l.poll());
        }
        while(s.size() > l.size() + 1){
            l.offer(s.poll());
        }
    }
}