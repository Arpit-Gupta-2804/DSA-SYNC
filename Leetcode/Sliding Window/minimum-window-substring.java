class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) return "";
        if(s.equals(t)) return s;

        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int sIndex = -1;
        for(int right=0; right<n; right++){
            char ch = s.charAt(right);
            if(hm.containsKey(ch) && hm.get(ch) > 0){
                count++;
            }
            hm.put(ch, hm.getOrDefault(ch, 0) - 1);
            while(count == m){
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    sIndex = left;
                }
                hm.put(s.charAt(left), hm.getOrDefault(s.charAt(left), 0) + 1);
                if(hm.get(s.charAt(left)) > 0) count--;
                left++;
            }
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLength);
    }
}