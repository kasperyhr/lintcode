public class TwoSum {
    Map<Integer, Integer> m = new HashMap<>();
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        m.put(number, m.getOrDefault(number, 0) + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for(int num: m.keySet()){
            if(num * 2 != value && m.containsKey(value - num)){
                return true;
            } else if(num * 2 == value && m.get(num) > 1){
                return true;
            }
        }
        return false;
    }
}