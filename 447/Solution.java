/**
 * Definition of ArrayReader:
 * 
 * public class ArrayReader {
 * public int get(int index) {
 *          // return the number on given index, 
 *          // return 2147483647 if the index is invalid.
 *     }
 * };
 */
public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int r = 1;
        while(reader.get(r) < target) r <<= 1;
        int l = (r >> 1);
        
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            int val = reader.get(m);
            if(val > target){
                r = m;
            } else if(val < target){
                l = m;
            } else {
                r = m;
            }
        }
        if(reader.get(l) == target) return l;
        else if(reader.get(r) == target) return r;
        return -1;
    }
}