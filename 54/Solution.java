public class Solution {
    /**
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
        boolean isStart = false;
        long val = 0;
        boolean isNegative = false;
        for(char c: str.toCharArray()){
            if(val - 1 > Integer.MAX_VALUE)
                break;
            switch(c){
                case ' ':
                    if(isStart)
                        return getVal(val, isNegative);
                    break;
                case '-':
                    if(!isStart){
                        isStart = true;
                        isNegative = true;
                        break;
                    } else {
                        return getVal(val, isNegative);
                    }
                case '+':
                    if(!isStart){
                        isStart = true;
                        break;
                    } else {
                        return getVal(val, isNegative);
                    }
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    isStart = true;
                    val *= 10;
                    val += (c - '0');
                    break;
                default:
                    return getVal(val, isNegative);
            }
            // System.out.println("" + isNegative + " " + val);
        }
        
        return getVal(val, isNegative);
    }
    
    private int getVal(long val, boolean isNegative){
        if(isNegative){
            val = -val;
            if(val < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return (int) val;
        } else {
            if(val > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int) val;
        }
    }
}