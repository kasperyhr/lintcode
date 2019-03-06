public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int l = 0;
        int r = A.length - 1;
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            if(A[m] < target)
                l = m;
            else if(A[m] > target)
                r = m;
            else l = m;
        }
        int[] ret = new int[k];
        for(int i = 0; i < k; i++){
            if(l < 0)
                ret[i] = A[r++];
            else if(r >= A.length)
                ret[i] = A[l--];
            else{
                int lv = Math.abs(A[l] - target);
                int rv = Math.abs(A[r] - target);
                if(lv <= rv)
                    ret[i] = A[l--];
                else
                    ret[i] = A[r++];
            }
        }
        return ret;
    }
}