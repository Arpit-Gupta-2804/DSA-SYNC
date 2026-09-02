class DisjointSet{
    int [] parent;
    int [] size;
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        } 
        return parent[node] = findParent(parent[node]);
    }
    public void UnionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;

        if(size[ulp_u] > size[ulp_v]){
            size[ulp_u] = size[ulp_u] + size[ulp_v];
            parent[ulp_v] = parent[ulp_u];
        }else if(size[ulp_v] > size[ulp_u]){
            size[ulp_v] = size[ulp_u] + size[ulp_v];
            parent[ulp_u] = parent[ulp_v];
        }else{
            size[ulp_u] = size[ulp_u] + size[ulp_v];
            parent[ulp_v] = parent[ulp_u];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        HashMap<String,Integer> mapMailNode = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(! mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail, i);
                }else{
                    ds.UnionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String> [] mergeMail = new ArrayList[n];

        for(int i=0; i<n; i++){
            mergeMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String, Integer> it : mapMailNode.entrySet()){
            String mail = it.getKey();
            int node = ds.findParent(it.getValue());
            mergeMail[node].add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<mergeMail.length; i++){
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergeMail[i]){
                temp.add(it);
            }
            res.add(temp);
        }
        return res;
    }
}