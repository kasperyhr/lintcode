public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(n == 0) return 1 % b;
        if(n == 1) return a % b;
        long val = (long) fastPower(a, b, n >> 1);
        val = (val * val) % (long) b;
        if((n & 1) == 0) return (int) val;
        return (int) ((val * a) % (long) b);
    }
}