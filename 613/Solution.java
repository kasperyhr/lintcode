/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, PriorityQueue<Integer>> m = new HashMap<>();
        for(Record r: results){
            PriorityQueue<Integer> q = 
                m.getOrDefault(r.id, new PriorityQueue<>());
            if(q.size() < 5){
                q.add(r.score);
            } else {
                if(q.peek() < r.score){
                    q.poll();
                    q.add(r.score);
                }
            }
            m.put(r.id, q);
        }
        
        Map<Integer, Double> res = new HashMap<>();
        for(int key: m.keySet()){
            PriorityQueue<Integer> q = m.get(key);
            int sum = 0;
            for(int i = 0; i < 5; i++){
                sum += q.poll();
            }
            double avg = (double) sum / 5;
            res.put(key, avg);
        }
        
        return res;
    }
}