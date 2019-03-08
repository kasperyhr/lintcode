public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        if(n == 1) return x;
        if(n == 0) return 1;
        if(n == -1) return 1 / x;
        double val = myPow(x, n / 2);
        if (n % 2 == 0)
            return val * val;
        else if(n % 2 == 1)
            return x * val * val;
        else
            return 1 / x * val * val;
    }
}