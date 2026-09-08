class Solution {
    public int countCommas(int n) {
        int digit = 0;
        int num = n;
        while(num > 0){
            digit++;
            num/=10;
        }
        int res = 0;
        if(digit <= 3) return 0;
        if(digit >= 4){
            res += (n-999);
            return res;
        }
        return res;
    }
}