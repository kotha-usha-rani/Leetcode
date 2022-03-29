class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        //using hashmap, but removing elements takes extra time 
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0 ; i<nums.length ; i++){
        //     map.put(nums[i], i);
        // }
        // int count = 1;
        // int max = 1;
        // for(int i=0 ; i<nums.length ; i++){
        //     if(map.containsKey(nums[i])){
        //         int k=1 ; count = 1 ;
        //         Integer ans = map.get(nums[i]-k);
        //         while(ans != null){
        //             count++;
        //             ans = map.remove(nums[i]-k++);
        //             ans = map.get(nums[i]-k);                
        //         }
        //         k=1 ;
        //         ans = map.get(nums[i]+k);
        //         while(ans != null){
        //             count++;
        //             ans = map.get(nums[i]+k++);
        //             ans = map.get(nums[i]+k);
        //         }
        //         max = Math.max(count, max);
        //     }
        // }
        // return max;
        
        //method 2 using hashset, start counting from min number so that we do not count the numbers again and again
        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i<nums.length ; i++)
            set.add(nums[i]);
        int count = 0;
        int max = 1 ;
        for(int i=0 ; i<nums.length ; i++){
            if(!set.contains(nums[i]-1)){
                count = 1 ; int k=1;
                while(set.contains(nums[i]+k++))
                    count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}