/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(root == null)
            return 0;
        if(start <= root.start && root.end <= end){
            return root.count;
        }
        
        int res = 0;
        int mid = (root.start + root.end) / 2;
        if(start <= mid){
            res += query(root.left, start, end);
        }
        if(mid + 1 <= end){
            res += query(root.right, start, end);
        }
        
        return res;
    }
}