/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start <= root.start && root.end <= end){
            return root.max;
        }
        
        int mid = (root.start + root.end) / 2;
        int max = Integer.MIN_VALUE;
        if(mid >= start){
            max = Math.max(query(root.left, start, end), max);
        }
        if(mid + 1 <= end){
            max = Math.max(query(root.right, start, end), max);
        }
        
        return max;
    }
}