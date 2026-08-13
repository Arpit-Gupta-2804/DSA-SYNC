class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> res =  new ArrayList<>();
        int [] indegree = new int [numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] prereq : prerequisites){
            int v = prereq[0];
            int u = prereq[1];
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
                    q.offer(neighbour);
                }
            }
        }

        if(res.size() == numCourses) return true;
        return false;
    }
}