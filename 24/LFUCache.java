public class LFUCache {
    int size;
    int len;
    Map<Integer, Integer> num2cnt;
    TreeMap<Integer, List<Integer>> cnt2lst;
    Map<Integer, Integer> cache;
    /*
    * @param capacity: An integer
    */
    public LFUCache(int capacity) {
        // do intialization if necessary
        size = capacity;
        len = 0;
        num2cnt = new HashMap<>();
        cnt2lst = new TreeMap<>();
        cache = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(!cache.containsKey(key)){
            if(size == len){
                evict();
            }
        }
        update(key);
        cache.put(key, value);
        // System.out.println(cnt2lst.get(3));
    }
    
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(cache.containsKey(key)){
            update(key);
            // System.out.println(cnt2lst.get(3));
            return cache.get(key);
        }
        // System.out.println(cnt2lst.get(3));
        return -1;
    }
    
    private void update(int key){
        if(!cache.containsKey(key)){
            List<Integer> l = cnt2lst.getOrDefault(1, new ArrayList<>());
            l.add(key);
            len += 1;
            cnt2lst.put(1, l);
        } else {
            int cnt = num2cnt.get(key);
            // System.out.println("--DEBUG--:" + key + " with cnt: " + cnt + " " + cnt2lst.get(cnt) + " " + cnt2lst.get(3));
            List<Integer> l = cnt2lst.get(cnt);
            int idx = l.indexOf(key);
            // System.out.println("HERE:" + key + " " + cnt + " " + idx);
            l.remove(idx);
            // System.out.println("HERE" + " " + cnt2lst.get(3));
            if(l.size() == 0)
                cnt2lst.remove(cnt);
            
            l = cnt2lst.getOrDefault(cnt + 1, new ArrayList<>());
            l.add(key);
            cnt2lst.put(cnt + 1, l);
            // System.out.println("PUT INTO CNT: " + (cnt + 1) + cnt2lst.get(cnt + 1) + " " + cnt2lst.get(3));
        }
        num2cnt.put(key, num2cnt.getOrDefault(key, 0) + 1);
    }
    
    private void evict(){
        int cnt = cnt2lst.firstKey();
        int key = cnt2lst.get(cnt).remove(0);
        if(cnt2lst.get(cnt).size() == 0)
            cnt2lst.remove(cnt);
        cache.remove(key);
        num2cnt.remove(key);
        len -= 1;
        // System.out.println("Evicted: " + key + " with cnt: " + cnt);
    }
}