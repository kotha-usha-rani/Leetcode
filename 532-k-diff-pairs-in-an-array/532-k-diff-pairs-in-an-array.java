class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0)+1);
        int count = 0;
        for(Integer ele : map.keySet()){
            if(k>0 && map.containsKey(ele-k) || k==0 && map.get(ele) > 1)
                count++;
        }
        return count;
    }
}