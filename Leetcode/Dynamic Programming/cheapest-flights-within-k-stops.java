class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adj.get(u).add(new int []{v, w});
        }
        int [] distance = new int [n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, src, 0));
        distance[src] = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int dist = curr.dist;
            int node = curr.node;
            int lvl = curr.lvl;

            if(lvl > k) continue;
            
            for(int [] next : adj.get(node)){
                int d = next[1];
                int v = next[0];
                if(distance[v] > d+dist && lvl <= k){
                    distance[v] = d + dist;
                    q.offer(new Pair(lvl + 1, v,  d + dist));
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
    class Pair{
        int dist;
        int node;
        int lvl;
        Pair(int lvl, int node, int dist){
            this.dist = dist;
            this.node = node;
            this.lvl = lvl; 
        }
    }
}