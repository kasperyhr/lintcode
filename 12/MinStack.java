public class MinStack {
    Stack<Integer> s;
    Stack<Integer> m;
    public MinStack() {
        // do intialization if necessary
        s = new Stack<Integer>();
        m = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        s.push(number);
        if(m.isEmpty()) m.push(number);
        else m.push(Math.min(m.peek(), number));
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        m.pop();
        return s.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return m.peek();
    }
}