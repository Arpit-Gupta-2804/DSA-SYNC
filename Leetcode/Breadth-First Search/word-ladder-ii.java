class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       List<List<String>> res = new ArrayList<>();
       HashSet<String> hs = new HashSet<>(wordList);
       hs.remove(beginWord);
       HashMap<String, Integer> hm = new HashMap<>(); 
       Queue<String> q = new LinkedList<>();
       q.offer(beginWord);
       hm.put(beginWord, 1);

       while(!q.isEmpty()){
            String curr = q.poll();
            int level = hm.get(curr);
            
            if(curr.equals(endWord)){
                break;
            }

            for(int i=0; i<curr.length(); i++){
                for(char j='a'; j<='z'; j++){
                    char [] ch = curr.toCharArray();
                    ch[i] = j;
                    String generated = new String(ch);
                    if(hs.contains(generated)){
                        q.offer(generated);
                        hs.remove(generated);
                        hm.put(generated, level+1);
                    }
                }
            }
        }

        if(hm.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, beginWord, seq, hm, res);
        }
        return res;
    }

    public static void dfs(String word, String b, List<String> seq, HashMap<String, Integer> hm, List<List<String>> res){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            res.add(dup);
            return;
        }
        int steps = hm.get(word);

        for(int i=0; i<word.length(); i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                char [] next = word.toCharArray();
                next[i] = ch;
                String generated = new String(next); 
                if(hm.containsKey(generated) && hm.get(generated) + 1 == steps){
                    seq.add(generated);
                    dfs(generated, b, seq, hm, res);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
}