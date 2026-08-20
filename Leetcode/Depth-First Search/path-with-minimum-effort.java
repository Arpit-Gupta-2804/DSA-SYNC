class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int [][] dist = new int [n][m];

        for(int [] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> x.d - y.d);
        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;
        int [] dr = {-1, 0, 1, 0};
        int [] dc = {0, 1, 0, -1};

        while(! pq.isEmpty()){
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int d = curr.d;

            if(row == n-1 && col == m-1) return d;

            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int effort = Math.max(Math.abs(heights[nr][nc] - heights[row][col]), d);
                    if(effort < dist[nr][nc]){
                        dist[nr][nc] = effort;
                        pq.offer(new Pair(effort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
    class Pair{
        int row;
        int col;
        int d;
        Pair(int d, int row, int col){
            this.d = d;
            this.row = row;
            this.col = col;
        }
    }
}