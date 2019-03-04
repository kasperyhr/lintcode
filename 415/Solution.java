public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            while(left < s.length() && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))){
                left ++;
            }
            
            while(right >= 0 && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))){
                right --;
            }
            
            if(left < s.length() && right >= 0 && left <= right){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
            }
            left ++;
            right --;
        }
        return true;
    }
}