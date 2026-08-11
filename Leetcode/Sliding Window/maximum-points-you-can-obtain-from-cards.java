class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int left = 0, right = n-1;

        int maxSum = 0, sum = 0;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        maxSum = Math.max(maxSum, sum);

        for(int i = k-1; i>=0; i--){
            sum -= cardPoints[i];
            sum += cardPoints[right];
            maxSum = Math.max(maxSum, sum);
            right--;
        }
        return maxSum;
    }
}