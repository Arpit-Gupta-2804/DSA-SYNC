class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLen = 0, maxFreq = 0;
        int [] freq = new int [26];

        for(int right=0; right < s.length(); right++){
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);
            int changes = (right - left + 1) - maxFreq;
            if(changes > k){
                char rch = s.charAt(left);
                freq[rch - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}