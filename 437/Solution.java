public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int low = 0;
        int high = 0;
        for(int page: pages){
            low = Math.max(page, low);
            high += page;
        }
        
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            int p = getPeople(pages, mid);
            if(p <= k){
                high = mid;
            } else {
                low = mid;
            }
        }
        if(getPeople(pages, low) <= k) return low;
        return high;
    }
    
    public int getPeople(int[] pages, int page){
        int cnt = 0;
        int prev = 0;
        for(int curr: pages){
            if(curr + prev <= page){
                prev += curr;
            } else {
                prev = curr;
                cnt += 1;
            }
        }
        if(prev > 0)
            cnt += 1;
        return cnt;
    }
}