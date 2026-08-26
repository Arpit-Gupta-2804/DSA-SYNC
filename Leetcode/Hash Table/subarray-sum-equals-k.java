class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int prefix = 0;
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            prefix += nums[i];
            if(hm.containsKey(prefix - k)){
                cnt += hm.get(prefix - k);
            }
            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1);
        }
        return cnt;
    }
}