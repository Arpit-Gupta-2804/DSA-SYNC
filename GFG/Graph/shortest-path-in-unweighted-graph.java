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
        boolean flag = false;
        while(!q.isEmpty()){
            int [] node = q.poll();
            int val = node[0];
            int w = node[1];
            for(int neigh : adj.get(val)){
                if(! visited[neigh]){
                    visited[neigh] = true;
                    if(neigh == dest){
                        dist = w + 1;
                        flag = true;
                        break;
                    }
                    q.offer(new int [] {neigh, w+1 });
                }
            }
            if(flag){
                break;
            }
        }
        return dist;
    }
}