class Solution {
    public int numberOfSubstrings(String s) {
        int [] index = new int [3];
        Arrays.fill(index, -1);
        int left = 0;
        int length = 0;
        for(int right = 0; right < s.length(); right++){
            if(s.charAt(right) == 'a') index[0] = right;
            else if (s.charAt(right) == 'b') index[1] = right;
            else index[2] = right;

            if(index[0] != -1 && index[1] != -1 && index[2] != -1){
                length += (Math.min(index[0], Math.min(index[1], index[2])) - left) + 1;
            } 
        }
        return length;
    }
}