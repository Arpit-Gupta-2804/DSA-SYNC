class Solution {
    class DisjointSet{
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
        DisjointSet(int n){
            for(int i=0; i<n; i++){
                parent.add(i);
                size.add(0);
            }
        }
        public int findParent(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ulp = findParent(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
        public void unionBySize(int u, int v){
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            if( ulp_u == ulp_v) return;

            if(size.get(ulp_u) > size.get(ulp_v)){
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
                parent.set(ulp_v, ulp_u);
            }
            if(size.get(ulp_v) > size.get(ulp_u)){
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
                parent.set(ulp_u, ulp_v);
            }
            if(size.get(ulp_u) == size.get(ulp_v)){
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
                parent.set(ulp_v, ulp_u);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for(int [] connection : connections){
            int u = connection[0];
            int v = connection[1];
            if(ds.findParent(u) != ds.findParent(v)){
                ds.unionBySize(u, v);
            }else{
                extraEdges++;
            }
        }
        int comp = 0;
        for(int i=0; i<n; i++){
            if(ds.findParent(i) == i){
                comp++;
            }
        }
        
        if(extraEdges >= comp - 1){
            return comp - 1;
        }
        return -1;
    }
}