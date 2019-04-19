public class Solution {
    /**
     * @param s: a string
     * @return: reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        // write your code here
        StringBuffer sb = new StringBuffer(s);
        int p1 = 0;
        int p2 = sb.length() - 1;
        while(p1 < p2){
            while(p1 < sb.length() && !isVowel(sb.charAt(p1)) ){
                p1++;
            }
            while(p2 >= 0 && !isVowel(sb.charAt(p2)) ){
                p2--;
            }
            if(p1 > p2){
                break;
            }
            char c1 = sb.charAt(p1);
            char c2 = sb.charAt(p2);
            sb.setCharAt(p1, c2);
            sb.setCharAt(p2, c1);
            p1++;
            p2--;
        }
        return new String(sb);
    }
    
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}