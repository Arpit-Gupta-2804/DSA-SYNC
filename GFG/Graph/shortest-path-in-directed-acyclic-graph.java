}
        boolean [] visited = new boolean [V];
        
        topoSort(0, adj, visited, st);
        
        int [] dist = new int[V];
        Arrays.fill(dist, -1);
        
        int src = st.peek();
        dist[src] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            int d = dist[node];
            for(Pair neigh : adj.get(node)){
                int neighNode = neigh.n;
                int weight = neigh.w;
                if(dist[neighNode] == -1){
                    dist[neighNode] = d + weight;
                }else{
                    dist[neighNode] = Math.min(dist[neighNode], d+weight);
                }
            }
        }
        for(int i=0; i<dist.length; i++){
            res.add(dist[i]);
        }
        return res;
    }
    public void topoSort(int node, ArrayList<ArrayList<Pair>> adj, 
        boolean [] visited, Stack<Integer> st){
        visited[node] = true;
        for(Pair neigh : adj.get(node)){