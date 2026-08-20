class Solution {
    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        int n = mat.length;
        int m = mat[0].length;
        
        if(mat[src[0]][src[1]] == 0 || mat[dest[0]][dest[1]] == 0) return -1;
        
        if(src[0] == dest[0] && src[1] == dest[1]) return 0;
        
        int [][] visited = new int [mat.length][mat[0].length];
        for(int [] row : visited){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[src[0]][src[1]] = 0;
        
        Queue<int []> q = new LinkedList<>();
        q.add(new int []{src[0], src[1], 0});
        
        int [] hori = {-1, 0, 1, 0};
        int [] verti = {0, 1, 0, -1};
        
        while(! q.isEmpty()){
            int [] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];
            
            for(int i=0; i<4; i++){
                int nrow = row + hori[i];
                int ncol = col + verti[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                mat[nrow][ncol] == 1 && visited[nrow][ncol] > dist + 1){
                    visited[nrow][ncol] = dist + 1;
                    if(nrow == dest[0] && ncol == dest[1]) return dist + 1;
                    q.offer(new int [] {nrow, ncol, dist + 1});
                }
            }
        }
        return -1;
    }
}