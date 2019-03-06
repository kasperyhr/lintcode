public class ConnectingGraph2 {
    int[] father;
    int[] size;
    /*
    * @param n: An integer
    */
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i <= n; i++){
            father[i] = i;
            size[i] = 1;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int fa = find(a);
        int fb = find(b);
        if(fb != fa){
            father[fa] = fb;
            size[fb] += size[fa];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        a = find(a);
        System.out.println(a);
        return size[a];
    }
    
    private int find(int a){
        int k = a;
        while(father[k] != k){
            k = father[k];
        }
        
        while(a != k){
            int tmp = father[a];
            father[a] = k;
            a = tmp;
        }
        return k;
    }
}