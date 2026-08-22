class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        int MOD = 1000;
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {start, 0});
        
        int [] dist = new int [1000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while(! q.isEmpty()){
            int [] curr = q.poll();
            int node = curr[0];
            int level = curr[1];
            
            if(node == end) return level;
            if(level > dist[node]) continue;
            
            for(int i=0; i<arr.length; i++){
                int next = (node * arr[i]) % MOD;
                
                if(next == end) return level + 1;
                
                if(dist[next] > level + 1){
                    dist[next] = level + 1;
                    q.offer(new int [] {next, level + 1});
                }
            }
        }
        return -1;
    }
}