class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
        }
        boolean [] visited = new boolean [V];
        Stack<Integer> st = new Stack<>();
        
        topoSort(0, visited, adj, st);
        
        int [] dist = new int [V];
        Arrays.fill(dist, -1);
        int node = st.peek();
        dist[node] = 0;
        while(! st.isEmpty()){
            int n = st.pop();
            int w = dist[n];
            for(Pair neigh : adj.get(n)){
                int neighNode =  neigh.n;
                int weight = neigh.w;
                if(dist[neighNode] == -1){
                    dist[neighNode] = w + weight;
                }else{
                    dist[neighNode] = Math.min(dist[neighNode], w + weight);
                }
            }
        }
        for(int i=0; i<dist.length; i++){
            res.add(dist[i]);
        }
        return res;
    }
    
    public static void topoSort(int node, boolean [] visited, ArrayList<ArrayList<Pair>> adj,
        Stack<Integer> st){
        visited[node] = true;
        for(Pair neigh : adj.get(node)){
            int neighNode = neigh.n;
            int weight = neigh.w;
            if(! visited[neighNode]){
                topoSort(neighNode, visited, adj, st);
            }
        }
        st.push(node);
        return;
    }
    class Pair{
        int n;
        int w;
        Pair(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
}