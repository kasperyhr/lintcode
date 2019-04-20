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
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        SegmentTree root = build(0, A.length - 1, A);
        
        List<Long> res = new ArrayList<>();
        for(Interval query: queries){
            res.add(q(root, query.start, query.end));
        }
        
        return res;
    }
    
    private long q(SegmentTree root, int start, int end){
        if(start <= root.start && root.end <= end){
            return root.sum;
        }
        
        long sum = 0;
        int mid = (root.start + root.end) / 2;
        if(start <= mid){
            sum += q(root.left, start, end);
        }
        if(mid + 1 <= end){
            sum += q(root.right, start, end);
        }
        
        return sum;
    }
    
    private SegmentTree build(int start, int end, int[] A){
        if(start > end)
            return null;
        
        SegmentTree root = new SegmentTree(start, end);
        root.sum = (long) A[start];
        if(start < end){
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);
            root.sum = root.left.sum + root.right.sum;
        }
        
        return root;
    }
}

class SegmentTree{
    int start, end;
    long sum;
    SegmentTree left, right;
    public SegmentTree(int start, int end){
        this.start = start;
        this.end = end;
        sum = 0;
        left = null;
        right = null;
    }
}