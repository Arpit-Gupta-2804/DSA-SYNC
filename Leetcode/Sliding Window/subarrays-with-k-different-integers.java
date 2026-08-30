class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k-1);
    }

    public int countAtMost(int [] nums, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();

        int left = 0;
        int count = 0;
        for(int right=0; right<nums.length; right++){
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            while(hm.size() > k){
                hm.put(nums[left], hm.getOrDefault(nums[left], 0) - 1);
                if(hm.get(nums[left]) == 0){
                    hm.remove(nums[left]);
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}