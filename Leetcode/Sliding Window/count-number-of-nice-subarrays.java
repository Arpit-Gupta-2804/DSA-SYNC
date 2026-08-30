class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return niceSubarrayAtMost(nums, k) - niceSubarrayAtMost(nums, k - 1);
    }

    public int niceSubarrayAtMost(int [] nums, int k){
        int left = 0;
        int sum = 0;
        int count = 0;

        for(int right=0; right<nums.length; right++){
            sum += (nums[right] % 2);
            while(sum > k){
                sum -= (nums[left] % 2);
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}