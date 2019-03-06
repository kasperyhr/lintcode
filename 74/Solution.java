/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int l = 1;
        int r = n;
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            boolean b = SVNRepo.isBadVersion(m);
            if(b)
                r = m;
            else
                l = m;
        }
        if(SVNRepo.isBadVersion(l)) return l;
        return r;
    }
}