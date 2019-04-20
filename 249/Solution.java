public class Solution {
    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        SegmentTree root = build(0, 10000);
        List<Integer> res = new ArrayList<>();
        for(int val: A){
            res.add(q(root, 0, val - 1));
            update(root, val, 1);
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
    
    private int q(SegmentTree root, int start, int end){
        if(root == null)
            return 0;
        if(start <= root.start && root.end <= end){
            return root.cnt;
        }
        
        int mid = (root.start + root.end) / 2;
        int cnt = 0;
        if(start <= mid){
            cnt += q(root.left, start, end);
        }
        
        if(mid + 1 <= end){
            cnt += q(root.right, start, end);
        }
        
        return cnt;
    }
    
    private SegmentTree build(int start, int end){
        if(start > end){
            return null;
        }
        
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