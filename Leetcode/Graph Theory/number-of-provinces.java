class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int n){
        for(int i=0; i<= n; i++){
            parent.add(i);
            size.add(0);
        }
    }

    public int findUnionParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ulp = findUnionParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUnionParent(u);
        int ulp_v = findUnionParent(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) > size.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }else if(size.get(ulp_v) > size.get(ulp_u)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(isConnected.length);
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(j != i && isConnected[i][j] == 1){
                    if(ds.findUnionParent(i) != ds.findUnionParent(j)){
                        cnt++;
                        ds.unionBySize(i, j);
                    }
                }
            }
        }
        return n - cnt;
    }
}




// -------------------Number of Provinces Using DFS--------------------
//  
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int V = isConnected.length;

//         boolean [] visited = new boolean [V];
//         int cnt = 0;
//         for(int i=0; i<V; i++){
//             if(!visited[i]){
//                 cnt++;
//                 dfsHelper(isConnected, i, visited);
//             }
//         }
//         return cnt;
//     }
//     public static void dfsHelper(int [][] isConnected, int node, boolean [] visited){
//         int V = isConnected.length;

//         for(int neighbour = 0; neighbour < V; neighbour++){
//             if(isConnected[node][neighbour] == 1 && ! visited[neighbour]){
//                 visited[neighbour] = true;
//                 dfsHelper(isConnected, neighbour, visited);
//             }
//         }
//     }
// }