class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int [][] adj = new int [n][n];
        for(int [] row : adj){
            Arrays.fill(row, (int)1e8);
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u][v] = w;
            adj[v][u] = w;
        }
        for(int i=0; i<n; i++){
            adj[i][i] = 0;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(adj[i][k] + adj[k][j] < adj[i][j]){
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        int maxCity = n;
        int city = -1;

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(adj[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(maxCity >= cnt){
                maxCity = cnt;
                city = i;
            }
        }

        return city;
    }
}