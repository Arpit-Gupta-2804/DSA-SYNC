class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int time = 0;
        int waitTime = 0;
        
        for(int i=0; i<bt.length; i++){
            time += bt[i];
            if(i != bt.length - 1){
                waitTime += time;
            }
        }
        return waitTime/bt.length;
    }
}