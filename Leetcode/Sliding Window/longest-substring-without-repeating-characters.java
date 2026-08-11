class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxLen = 0;
        while(right < s.length()){
            if(hm.containsKey(s.charAt(right))){
                left = Math.max(left, hm.get(s.charAt(right)) + 1);
            }
            hm.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++; 
        }
        return maxLen;
    }
}