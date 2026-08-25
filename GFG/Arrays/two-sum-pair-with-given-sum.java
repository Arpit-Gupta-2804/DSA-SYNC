class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        HashSet<Integer> hs = new HashSet<>();
        for(int num : arr){
            if(hs.contains(target - num)){
                return true;
            }
            hs.add(num);
        }
        
        return false;
    }
}