class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i], i);
        }
        int count = 1;
        int max = 1;
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                int k=1 ; count = 1 ;
                Integer ans = map.get(nums[i]-k);
                while(ans != null){
                    count++;
                    ans = map.remove(nums[i]-k++);
                    ans = map.get(nums[i]-k);                
                }
                k=1 ;
                ans = map.get(nums[i]+k);
                while(ans != null){
                    count++;
                    ans = map.get(nums[i]+k++);
                    ans = map.get(nums[i]+k);
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}