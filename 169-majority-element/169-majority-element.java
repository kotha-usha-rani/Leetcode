class Solution {
    public int majorityElement(int[] nums) {
        //Method 1 sort the array, find the max count of each element, return the ele with max count
        // Arrays.sort(nums);
        // int count = 1;
        // int max = 0;
        // int ele = 0 ;
        // int prev = nums[0];
        // for(int i=1 ; i<nums.length ; i++){
        //     if(nums[i] == prev)
        //         count++;
        //     else{
        //         if(count > max){
        //             max = count;
        //             ele = prev ;
        //         }
        //         prev = nums[i];
        //         count = 1 ;
        //     }
        // }
        // if(count > max)
        //     return prev;
        // return ele;  
        
        //maintain a count, after traversing the array once is the count value is greater than 1 then the element associated to the count is the answer, majority element always exits in the array, so count of majority element is always greater than the count of rest of the elements Therefore maj(count) - rest(count) >= 1
        // int count = 0;
        // int ele = 0;
        // for(int i=0 ; i<nums.length ; i++){
        //     if(count == 0){
        //         ele = nums[i];
        //     }
        //     if(nums[i] == ele)
        //         count++;
        //     else
        //         count--;
        // }
        // return ele;
        
        //HashMap to store the count of elements\
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i]))
               map.put(nums[i], map.get(nums[i])+1);
            else
               map.put(nums[i], 1);
        }
        for(Integer ele : map.keySet()){
            if(map.get(ele) > nums.length/2)
                return ele;
        }
        return 0;
    }
}









