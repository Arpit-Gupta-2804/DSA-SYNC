class Solution {
    public int maxArea(int[] height) {
        int maxStorage = 0;
        int left = 0;
        int right = height.length - 1;

        while(left <= right){
            int value = Math.min(height[left], height[right]) * (right-left);
            maxStorage = Math.max(maxStorage, value);
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxStorage;
    }
}