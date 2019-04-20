public class Solution {
    /**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        SegmentTree root = build(0, 10000);
        
        for(int i: A){
            update(root, i, 1);
        }
        
        
        List<Integer> res = new ArrayList<>();
        for(int query: queries){
            res.add(q(root, 0, query - 1));
        }
        
        return res;
    }
    
    private int q(SegmentTree root, int start, int end){
        if(start <= root.start && root.end <= end){
            return root.cnt;
        }
        
        int mid = (root.start + root.end) / 2;
        int res = 0;
        if(start <= mid){
            res += q(root.left, start, end);
        }
        if(mid + 1 <= end){
            res += q(root.right, start, end);
        }
        
        return res;
    }
    
    private void update(SegmentTree root, int idx, int val){
        if(root.start == root.end){
            if(root.start == idx){
                root.cnt += val;
            }
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if(idx <= mid){
            update(root.left, idx, val);
        }
        if(mid + 1 <= idx){
            update(root.right, idx, val);
        }
        root.cnt = root.left.cnt + root.right.cnt;
        
    }
    
    private SegmentTree build(int start, int end){
        if(start > end)
            return null;
        SegmentTree root = new SegmentTree(start, end);
        if(start < end){
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        
        return root;
    }
}

class SegmentTree{
    int start, end;
    int cnt;
    SegmentTree left, right;
    public SegmentTree(int start, int end){
        this.start = start;
        this.end = end;
        cnt = 0;
        left = null;
        right = null;
    }
}