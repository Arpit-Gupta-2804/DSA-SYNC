class Solution {
    int minCost(int[] height) {
        // code here
        int [] dp = new int [height.length + 1];
        Arrays.fill(dp, -1);
        return helper(height, height.length - 1, dp);
    }
    private int helper(int [] height, int n, int [] dp){
        if(n == 0) return 0;
        
        if(dp[n] != -1) return dp[n];
        
        int left = helper(height, n-1, dp) + Math.abs(height[n] - height[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = helper(height, n-2, dp) + Math.abs(height[n] - height[n-2]);
            
        return dp[n] = Math.min(left, right);
    }
}