class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }
        
        int [] distance = new int [V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y)-> x.w - y.w);
        pq.offer(new Pair(0, src));
        
        while(! pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.n;
            int weigh = curr.w;
            
            if(weigh > distance[node]){
                continue;
            }
            for(Pair neigh : adj.get(node)){
                int next = neigh.n;
                int dist = neigh.w;
                if(weigh + dist < distance[next]){
                    distance[next] = weigh + dist;
                    pq.offer(new Pair(distance[next], next));
                }
            }
        }
        for(int d : distance){
            res.add(d);
        }
        return res;
    }
    class Pair{
        int n;
        int w;
        Pair(int w, int n){
            this.n = n;
            this.w = w;
        }
    }
}