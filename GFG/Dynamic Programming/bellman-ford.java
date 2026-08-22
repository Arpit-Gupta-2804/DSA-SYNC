class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int [] distance = new int [V];
        Arrays.fill(distance, (int)1e8);
        distance[src] = 0;
           
        for(int i=0; i<V-1; i++){
            for(int [] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(distance[u] != 1e8 && w + distance[u] < distance[v]){
                    distance[v] = w + distance[u];
                }
            }
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
                
            if(distance[u] != 1e8 && w + distance[u] < distance[v]){
                ArrayList<Integer> cycle = new ArrayList<>();
                cycle.add(-1);
                return cycle;
            }
        }
        
        for(int dist : distance){
            res.add(dist);
        }
        return res;
    }
}