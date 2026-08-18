class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int [] freq = new int [51];
        for(int i=0; i<= n-k; i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j = i; j < i+k; j++){
                hs.add(nums[j]);
            }

            for(int nm : hs){
                freq[nm]++;
            }
        }
        for(int num = 50; num>=0; num--){
            if(freq[num] == 1){
                return num;
            }
        }
        return -1;
    }
}