class Solution {
    // Milestone 11 UPDATE TEST
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int left = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxLen = 0;
        for(int right=0; right<n; right++){
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            while(freq.get(ch) > 2){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++; 
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}