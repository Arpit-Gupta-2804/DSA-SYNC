class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int start = lower;
        int end = upper;
        int idx = 0;

        while(idx < n && nums[idx] < start){
            idx++;
        }
        while(start <= end){
            ArrayList<Integer> temp = new ArrayList<>();
            if(idx >= n || nums[idx] > end){
                temp.add(start);
                temp.add(end);
                res.add(temp);
                break;
            }

            if(start < nums[idx]){
                temp.add(start);
                temp.add(nums[idx] - 1);
                res.add(temp);
            }

            start = nums[idx] + 1;
            idx++;
        }
        return res;
    }
}