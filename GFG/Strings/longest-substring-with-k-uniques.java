class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int left = 0;
        int maxLen = 0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        boolean check = false;
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            
            if(hm.size() >= k) check = true;
            while(hm.size() > k){
                char rch = s.charAt(left);
                hm.put(rch, hm.get(rch) - 1);
                if(hm.get(rch) == 0)  hm.remove(rch);
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        if(!check) return -1;
        return maxLen;
    }
}