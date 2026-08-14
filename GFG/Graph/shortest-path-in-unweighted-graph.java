class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int dist = -1;
        boolean [] visited = new boolean [V];
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {src, 0});
        visited[src] = true;
        while(!q.isEmpty()){
            int [] node = q.poll();
            int val = node[0];
            int w = node[1];
            for(int neigh : adj.get(val)){
                if(! visited[neigh]){
                    visited[neigh] = true;
                    if(neigh == dest){
                        dist = w + 1;
                    }
                    q.offer(new int [] {neigh, w+1 });
                }
            }
        }