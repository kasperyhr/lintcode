public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        int len = target.length();
        for(int i = 0; i < source.length() - len + 1; i++){
            if(source.substring(i, i + len).hashCode() == target.hashCode())
                return i;
        }
        return -1;
    }
}