class Pair{
    public int x, y, val;
    public Pair(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        if(heights.length == 0 || heights[0].length == 0){
            return 0;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        int ret = 0;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>((a, b) -> (a.val - b.val));
        boolean[][] done = new boolean[m][n];
        int i, j, d, nx, ny;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                done[i][j] = false;
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                    heap.offer(new Pair(i, j, heights[i][j]));
                    done[i][j] = true;
                }
            }
        }
        
        while(!heap.isEmpty()){
            Pair top = heap.poll();
            for(d = 0; d < 4; d++){
                nx = top.x + dx[d];
                ny = top.y + dy[d];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !done[nx][ny]){
                    int val = Math.max(top.val, heights[nx][ny]);
                    ret += val - heights[nx][ny];
                    done[nx][ny] = true;
                    heap.offer(new Pair(nx, ny, val));
                }
            }
        }
        
        return ret;
    }
}