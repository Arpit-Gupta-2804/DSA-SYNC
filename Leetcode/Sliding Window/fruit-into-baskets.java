class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        while(right < fruits.length){
            if(freq.size() > 2){
                freq.put(fruits[left], freq.get(fruits[left]) - 1);
                if(freq.get(fruits[left]) == 0) freq.remove(fruits[left]);
                left++;
            }else if(freq.size() <= 2){
                freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);
                right++;
            }
            if(freq.size() <= 2) maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen - 1;
    }
}