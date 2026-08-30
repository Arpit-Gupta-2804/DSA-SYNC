class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int min_index = 0;
        int max_index = 0;
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
                max_index = i;
            }
            if(nums[i] < min){
                min = nums[i];
                min_index = i;
            }
        }
        int min_op = 0;
        if(min_index > max_index){
            min_op = Math.min(min_index - 0 + 1, n - max_index);
            min_op = Math.min(min_op, (max_index - 0 + 1) + (n - min_index));
        }else if(min_index < max_index){
            min_op = Math.min(max_index - 0 + 1, n - min_index);
            min_op = Math.min(min_op, (min_index - 0 + 1) + (n - max_index));
        }
        return min_op;
    }
}