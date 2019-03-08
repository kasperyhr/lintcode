public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) return -1;
        int l = 0;
        int r = A.length - 1;
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            if(target >= A[0]){
                if(A[m] > target || A[m] < A[0]){
                    r = m;
                } else {
                    l = m;
                }
            } else {
                if(A[m] >= A[0] || A[m] < target){
                    l = m;
                } else {
                    r = m;
                }
            }
        }
        if(A[l] == target) return l;
        else if(A[r] == target) return r;
        return -1;
    }
}