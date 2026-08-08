class Solution {
    public int orangesRotting(int[][] grid) {
        int [][] visited = new int [grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
                visited[i][j] = grid[i][j];
            }
        }
        int time = 0;
        while(! q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int t = p.time;
            
            time = t;
            for(int delrow = -1; delrow <= 1; delrow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    if((delrow == 0 && delcol == 0) || (delrow == -1 && delcol == -1) || 
                    (delrow == 1 && delcol == 1) || (delrow == -1 && delcol == 1) || (delrow == 1 && delcol == -1)){continue;}

                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length 
                    && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 1){
                        visited[nrow][ncol] = 2;
                        q.add(new Pair(nrow, ncol, t+1));
                    }
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(visited[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
}

class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}