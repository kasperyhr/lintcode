public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int l = 0;
        int r = matrix[0].length - 1;
        int cnt = 0;
        for(int i = 0; i < matrix.length; i++){
            int val = binarySearch(matrix[i], target, l, r);
            if(val >= 0){
                cnt += 1;
                r = val - 1;
            } else {
                val = -(val + 1);
                r = val;
            }
        }
        return cnt;
    }
    
    private int binarySearch(int[] arr, int target, int l, int r){
        if(r < l) return -1;
        if(l == r){
            if(arr[l] == target)
                return l;
            return -1;
        } 
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            if(arr[m] < target)
                l = m;
            else
                r = m;
        }
        if(arr[l] < target){
            if(arr[r] == target){
                return r;
            } else {
                if(arr[r] < target){
                    return -r - 1;
                } else {
                    return -l - 1;
                }
            }
        } else if(arr[l] > target){
            return -l - 1;
        } else return l;
    }
}