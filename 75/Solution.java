public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int l = 0;
        int r = A.length - 1;
        int m;
        while(l + 1 < r){
            m = l + (r - l) / 2;
            if(m == A.length - 1 || A[m] < A[m + 1]){
                l = m;
            } else if(m == 0 || A[m] < A[m - 1]){
                r = m;
            } else {
                return m;
            }
        }
        if(l > 0 && l < A.length - 1 && A[l] > A[l - 1] && A[l] > A[l + 1]){
            return l;
        }
        return r;
    }
}