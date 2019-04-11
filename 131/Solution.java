class Event{
    int x;
    int y;
    boolean isStart;
    Event(int x, int y, boolean isStart){
        this.x = x;
        this.y = y;
        this.isStart = isStart;
    }
}

class EventComparator implements Comparator<Event>{
    @Override
    public int compare(Event a, Event b){
        if(a.x < b.x) return -1;
        else if(a.x > b.x) return 1;
        else if(a.isStart || !b.isStart) return -1;
        else return 1;
    }
}

public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        if(buildings.length == 0) return new ArrayList<>();
        
        PriorityQueue<Event> pq = new PriorityQueue(new EventComparator());
        for(int[] building: buildings){
            Event e1 = new Event(building[0], building[2], true);
            Event e2 = new Event(building[1], building[2], false);
            pq.add(e1);
            pq.add(e2);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        int prevHeight = 0;
        int prevX = pq.peek().x;
        while(!pq.isEmpty()){
            Event e = pq.poll();
            // System.out.println(e.x + " " + e.y + " " + e.isStart);
            if(e.isStart){
                heights.put(e.y, heights.getOrDefault(e.y, 0) + 1);
            } else {
                heights.put(e.y, heights.get(e.y) - 1 );
                if(heights.get(e.y) == 0){
                    heights.remove(e.y);
                }
            }
            
            if(prevX != e.x && prevHeight != 0){
                if(res.size() > 0 && res.get(res.size() - 1).get(2) == prevHeight && res.get(res.size() - 1).get(1) == prevX){
                    // System.out.println(prevX + " " + prevHeight);
                    res.get(res.size() - 1).set(1, e.x);
                } else {
                    List<Integer> line = new ArrayList<>();
                    line.add(prevX);
                    line.add(e.x);
                    line.add(prevHeight);
                    res.add(line);
                }
            }
            
            prevX = e.x;
            if(heights.size() == 0) 
                prevHeight = 0;
            else{
                prevHeight = heights.lastKey();
            }
            // System.out.println(prevHeight);
        }
        
        return res;
    }
}