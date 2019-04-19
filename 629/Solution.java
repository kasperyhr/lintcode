/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    Map<String, String> father;
    Map<String, Integer> len;
    
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        
        father = new HashMap<>();
        len = new HashMap<>();
        
        for(Connection c: connections){
            if(!father.containsKey(c.city1)){
                father.put(c.city1, c.city1);
                len.put(c.city1, 0);
            }
            
            if(!father.containsKey(c.city2)){
                father.put(c.city2, c.city2);
                len.put(c.city2, 0);
            }
        }
        
        Collections.sort(connections, (a, b) -> {
            if(a.cost - b.cost != 0)
                return a.cost - b.cost;
            if(!a.city1.equals(b.city1))
                return a.city1.compareTo(b.city1);
            return a.city2.compareTo(b.city2);
        });
        List<Connection> res = new ArrayList<>();
        for(int i = 0; i < connections.size(); i++){
            if(res.size() == father.size() - 1){
                break;
            }
            
            Connection c = connections.get(i);
            union(c, res);
        }
        
        if(res.size() != father.size() - 1)
            res = new ArrayList<>();
        return res;
    }
    
    private String find(String s){
        String tmp = s;
        while(!father.get(tmp).equals(tmp)){
            tmp = father.get(tmp);
        }
        String f;
        while(!s.equals(tmp)){
            f = father.get(s);
            father.put(s, tmp);
            s = f;
        }
        return tmp;
    }
    
    private void union(Connection c, List<Connection> res){
        String f1 = find(c.city1);
        String f2 = find(c.city2);
        if(!f1.equals(f2)){
            father.put(f1, f2);
            len.put(f2, len.get(f1) + len.get(f2) + c.cost);
            res.add(c);
        }
    }
}