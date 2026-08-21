class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new int [] {v, w});
        }
        int [] time = new int [n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> x.time - y.time); 
        pq.offer(new Pair(0, k));
        time[k] = 0;

        while(! pq.isEmpty()){
            Pair curr = pq.poll();
            int t = curr.time;
            int node = curr.node;

            if(t > time[node]) continue;
            
            for(int [] next : adj.get(node)){
                int v = next[0];
                int newTime = next[1];
                if(time[v] > t + newTime){
                    time[v] = t + newTime;
                    pq.offer(new Pair(t + newTime, v));
                }
            }
        }
        int res = -1;
        for(int t = 0; t<time.length; t++){
            if(t == 0) continue;
            if(time[t] == Integer.MAX_VALUE) return -1;
            res = Math.max(time[t], res);
        }
        return res;
    }
    class Pair{
        int time;
        int node;
        Pair(int time, int node){
            this.time = time;
            this.node = node;
        }
    }
}