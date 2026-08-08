class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] arr = {-1,-1};
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            int rem = target - nums[i];
            if(hm.containsKey(rem)){
                arr[0] = hm.get(rem);
                arr[1] = i;
            }
            hm.put(nums[i], i);
        }
        return arr;
    }
}