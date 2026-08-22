class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        for(int k=0; k<dist.length; k++){
            for(int i=0; i<dist.length; i++){
                for(int j=0; j<dist[0].length; j++){
                    if(i == j) continue;
                    if((dist[i][k] != 1e8 && dist[k][j] != 1e8) && dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}