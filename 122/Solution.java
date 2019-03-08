public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if(height == null || height.length == 0){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            int curr = (i == height.length) ? -1 : height[i];
            
            while(!stack.isEmpty() && curr <= height[stack.peek()]){
                int h = height[stack.pop()];
                int left = stack.isEmpty() ? 0 : (stack.peek() + 1);
                int right = i;
                max = Math.max(max, (right - left) * h);
            }
            
            stack.push(i);
        }
        return max;
    }
}