class Solution {
    int minCost(int[] height) {
        // code here
        int prev = 0;
        int curr = 0;
        
        for(int i=1; i<height.length; i++){
            int left = curr + Math.abs(height[i] -  height[i-1]);
            
            int right = Integer.MAX_VALUE;
            if(i > 1)    
                right = prev + Math.abs(height[i] - height[i-2]);
            int next = Math.min(right, left);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}