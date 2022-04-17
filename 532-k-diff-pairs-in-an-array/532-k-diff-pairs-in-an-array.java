class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int ele : nums){
            if(map.containsKey(ele))
                map.put(ele, map.get(ele)+1);
            else
                map.put(ele, 1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            map.put(entry.getKey() , entry.getValue()-1);
            if(map.containsKey(entry.getKey()-k) && map.get(entry.getKey()-k) > 0)
                count++;
            map.put(entry.getKey(), 0);
        }
        return count;
    }
}