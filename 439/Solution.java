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
    int[] A;
    /**
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        this.A = A;
        return build(0, A.length - 1);
    }
    
    private SegmentTreeNode build(int start, int end){
        if(start > end)
            return null;
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, A[start]);
        if(start < end){
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
            root.max = Math.max(root.left.max, root.right.max);
        }
        
        return root;
    }
}