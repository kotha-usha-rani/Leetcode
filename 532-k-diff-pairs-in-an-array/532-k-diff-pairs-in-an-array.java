class Solution {
    public int findPairs(int[] nums, int k) {
         HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums){
            if(map.containsKey(ele))
                map.put(ele, map.get(ele)+1);
            else
                map.put(ele, 1);
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])-1);
                if(map.containsKey(nums[i]-k) && map.get(nums[i]-k) > 0){
                    count++;
                }
                map.remove(nums[i]);
            }
        }
        return count;
    }
}