class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int [] reserve : reservedSeats){
            int r = reserve[0];
            int c = reserve[1];
            hm.putIfAbsent(r, new HashSet<>());
            hm.get(r).add(c);
        }
        int res = (n - hm.size()) * 2;
        for(HashSet<Integer> seats: hm.values()){
            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for(int i=2; i<=5; i++){
                if(seats.contains(i)){
                    left = false;
                    break;
                }
            }
            for(int i=4; i<=7; i++){
                if(seats.contains(i)){
                    middle = false;
                    break;
                }
            }

            for(int i=6; i<=9; i++){
                if(seats.contains(i)){
                    right = false;
                    break;
                }
            }
            if(left && right){
                res+=2;
            }else if(left ||  middle || right){
                res+=1;
            }
        }
        return res;
    }
}