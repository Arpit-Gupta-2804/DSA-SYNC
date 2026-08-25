class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>(); 
        for(String s : strs){
            int [] count = new int [26];
            for(char ch : s.toCharArray()){
                count[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int val : count){
                sb.append('#');
                sb.append(val);
            }
            String key = sb.toString();
            if(!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}