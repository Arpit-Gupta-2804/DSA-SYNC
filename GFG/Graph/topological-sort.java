//         for(int i=0; i<V; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0; i<edges.length; i++){
//             int u = edges[i][0];
//             int v = edges[i][1];
//             adj.get(u).add(v);
//         }
//         boolean [] visited = new boolean [V];
//         Stack<Integer> st = new Stack<>();
//         for(int i=0; i<V; i++){
//             if(!visited[i]){
//                 dfs(i, visited, adj, st);
//             }
//         }
        
//         while(! st.isEmpty()){
//             int val = st.pop();
//             res.add(val);
//         }
//         return res;
//     }