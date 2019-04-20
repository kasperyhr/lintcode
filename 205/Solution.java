/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param A: An integer array
     * @param queries: An query list
     * @return: The result list
     */
    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        // write your code here
        SegmentTree root = build(0, A.length - 1, A);
        
        List<Integer> res = new ArrayList<>();
        for(Interval query: queries){
            res.add(q(root, query.start, query.end));
        }
        
        return res;
    }
    
    private int q(SegmentTree root, int start, int end){
        if(start <= root.start && root.end <= end){
            return root.min;
        }
        
        int mid = (root.start + root.end) / 2;
        int res = Integer.MAX_VALUE;
        if(start <= mid){
            res = Math.min(res, q(root.left, start, end));
        }
        
        if(mid + 1 <= end){
            res = Math.min(res, q(root.right, start, end));
        }
        
        return res;
    }
    
    private SegmentTree build(int start, int end, int[] A){
        if(start > end){
            return null;
        }
        
        SegmentTree root = new SegmentTree(start, end);
        root.min = A[start];
        
        if(start < end){
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);
            root.min = Math.min(root.left.min, root.right.min);
        }
        
        return root;
    }
}

class SegmentTree{
    int start, end;
    int min;
    SegmentTree left, right;
    
    public SegmentTree(int start, int end){
        this.start = start;
        this.end = end;
        min = 0;
        left = null;
        right = null;
    }
}