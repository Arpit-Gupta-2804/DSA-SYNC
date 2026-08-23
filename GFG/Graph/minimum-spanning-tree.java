class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new int []{v, w});
            adj.get(v).add(new int []{u, w});
        }
        boolean [] visited = new boolean [V];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)-> 
        Integer.compare(x.weight, y.weight));
        pq.add(new Tuple(0, 0, -1));
        int sum = 0;
        while(! pq.isEmpty()){
            Tuple curr = pq.poll();
            int w = curr.weight;
            int u = curr.node;
            int v = curr.parent;
            if(visited[u]) continue;

            visited[u] = true;
            sum += w;

            
            for(int [] neigh : adj.get(u)){
                int next = neigh[0];
                int nextW = neigh[1];
                pq.offer(new Tuple(nextW, next, u));
            }
        }
        return sum;
    }
    class Tuple{
        int weight;
        int node;
        int parent;
        Tuple(int weight, int node, int parent){
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }
}