class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums){
            hs.add(num);
        }
        int n = (100/k) + 1;
        for(int i=1; i<=n; i++){
            if(!hs.contains(i*k)){
                return i*k;
            }
        }
        return -1;
    }
}