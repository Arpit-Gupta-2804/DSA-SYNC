class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        
        int maxCount = 1;
        for(int num : hs){
            int cnt = 1;
            int n = num;
            if(! hs.contains(n - 1)){
                while(hs.contains(n + 1)){
                    cnt++;
                    n++;
                }
                maxCount = Math.max(cnt, maxCount);
            }
        }
        return maxCount;
    }
}