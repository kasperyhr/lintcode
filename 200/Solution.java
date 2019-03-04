public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if(s.length() == 0){
            return "";
        }
        int ret = 0;
        String str = "";
        for(int i = 0; i < s.length(); i++){
            int ptr1 = i;
            int ptr2 = i;
            while(ptr1 >= 0 && ptr2 < s.length() && s.charAt(ptr1) == s.charAt(ptr2)){
                ptr1 --;
                ptr2 ++;
            }
            ret = Math.max(ret, ptr2 - ptr1 - 1);
            str = s.substring(ptr1 + 1, ptr2).length() > str.length() ? s.substring(ptr1 + 1, ptr2) : str;
        }
        
        for(int i = 0; i < s.length() - 1; i++){
            int ptr1 = i;
            int ptr2 = i + 1;
            while(ptr1 >= 0 && ptr2 < s.length() && s.charAt(ptr1) == s.charAt(ptr2)){
                ptr1 --;
                ptr2 ++;
            }
            ret = Math.max(ret, ptr2 - ptr1 - 1);
            str = s.substring(ptr1 + 1, ptr2).length() > str.length() ? s.substring(ptr1 + 1, ptr2) : str;
        }
        
        return str;
    }
}