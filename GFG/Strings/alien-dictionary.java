for(int i=0; i<26; i++){
            if(present[i] && !visited[i]){
                if(!topoSort(i, visited, pathVisited, adj, st)){
                    return "";
                }
            }
        }
        String res = "";
        while(! st.isEmpty()){
            int val = st.pop();
            char ch =(char) (val + 'a');
            res+=ch;
        }
        if(res.length() != cnt) return "";
        return res;
    }
    public static boolean topoSort(int node, boolean [] visited, boolean [] pathVisited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node] = true;
        pathVisited[node] = true;
        for(int neigh : adj.get(node)){
            if(! visited[neigh]){
                if(!topoSort(neigh, visited, pathVisited, adj, st)){
                    return false;
                };
            }else if(pathVisited[neigh]){
                return false;
            }
        }
        pathVisited[node] = false;
        st.push(node);
        return true;
    }
}