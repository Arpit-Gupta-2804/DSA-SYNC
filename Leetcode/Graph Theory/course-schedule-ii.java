class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int [] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] pre : prerequisites){
            int v = pre[0];
            int u = pre[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(! q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        int [] ans = new int[numCourses];
        for(int i=0; i<res.size(); i++){
            int val = res.get(i);
            ans[i] = val;
        }
        if(res.size() == numCourses){
            return ans;
        }
        return new int [0];
    }
}