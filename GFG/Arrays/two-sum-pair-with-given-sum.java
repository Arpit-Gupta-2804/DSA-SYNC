class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int j = 0;
        for(int num : arr){
            hm.put(num, j);
            j++;
        }
        
        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(target - arr[i]) && hm.get(target - arr[i]) != i){
                return true;
            }
        }
        return false;
    }
}