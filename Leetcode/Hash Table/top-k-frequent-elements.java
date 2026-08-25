class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        List<Integer> []  bucket = new ArrayList[nums.length + 1];;

        for(Map.Entry<Integer, Integer> it : hm.entrySet()){
            int key =  it.getKey();
            int val = it.getValue();
            
            if(bucket[val] == null){
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }
        int [] res = new int[k];
        int idx = 0;
        for(int i=nums.length; i>=0; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[idx] = num;
                    idx++;
                    if(idx == k){
                        return res;
                    }
                }
            }
        }
        return res;
    }
}