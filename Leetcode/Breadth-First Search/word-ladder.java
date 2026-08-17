class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for(String s : wordList){
            if(s.equals(beginWord)){
                continue;
            }
            hs.add(s);
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while(! q.isEmpty()){
            Pair p = q.poll();
            String curr = p.s;
            int level = p.lvl;

            if(curr.equals(endWord)) return level;

            for(int i=0; i<curr.length(); i++){
                for(char j='a'; j<='z'; j++){
                    char [] ch = curr.toCharArray();
                    ch[i] = j;
                    String replacedString = new String(ch);
                    if(hs.contains(replacedString)){
                        q.offer(new Pair(replacedString, level + 1));
                        hs.remove(replacedString);
                    }
                }
            }
        }
        return 0;
    }
    class Pair{
        String s;
        int lvl;
        Pair(String s, int lvl){
            this.s = s;
            this.lvl = lvl;
        }
    }
}