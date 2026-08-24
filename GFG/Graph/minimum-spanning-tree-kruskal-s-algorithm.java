class DisjointSet{
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    DisjointSet(int n){
        for(int i=0; i<=n; i++){
            size.add(0);
            parent.add(i);
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
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));
        
        DisjointSet ds = new DisjointSet(V);
        int wt = 0;
        int cnt = 0;
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(ds.findUnionParent(u) != ds.findUnionParent(v)){
                wt += w;
                ds.unionBySize(u, v);
                
                cnt++;
                if(cnt == V - 1){
                    break;
                }
            }
        }
        return wt;
    }
}