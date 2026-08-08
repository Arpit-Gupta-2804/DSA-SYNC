class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        boolean [] visited = new boolean [V];
        int cnt = 0;
        for(int i=0; i<V; i++){
            if(!visited[i]){
                cnt++;
                dfsHelper(isConnected, i, visited);
            }
        }
        return cnt;
    }
    public static void dfsHelper(int [][] isConnected, int node, boolean [] visited){
        int V = isConnected.length;

        for(int neighbour = 0; neighbour < V; neighbour++){
            if(isConnected[node][neighbour] == 1 && ! visited[neighbour]){
                visited[neighbour] = true;
                dfsHelper(isConnected, neighbour, visited);
            }
        }
    }
}