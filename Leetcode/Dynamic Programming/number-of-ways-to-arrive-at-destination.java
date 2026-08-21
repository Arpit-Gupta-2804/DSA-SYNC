class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int) (1e9 + 7);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] road : roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }
        long [] time = new long [n];
        Arrays.fill(time, Long.MAX_VALUE);
        int [] ways = new int [n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> Long.compare(x.time, y.time));
        pq.offer(new Pair(0, 0));
        time[0] = 0;
        ways[0] = 1;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            long t = curr.time;
            int node = curr.node;

            if(t > time[node]) continue;
        
            for(Pair next : adj.get(node)){
                int v = next.node;
                long newTime = next.time;
                
                if(time[v] > t + newTime){
                    time[v] = t + newTime;
                    pq.offer(new Pair(time[v], v));
                    ways[v] = ways[node];
                }else if(time[v] == t + newTime){
                    ways[v] = (ways[v] + ways[node]) % MOD;
                }
            } 
        }
        return ways[n-1] % MOD;
    }

    class Pair{
        long time;
        int node;
        Pair(long time, int node){
            this.time = time;
            this.node = node;
        }
    }
}