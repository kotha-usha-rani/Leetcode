class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Method 1 using 2 loops
        // int[] ans = new int[nums1.length];
        // int k=0;
        // for(int i=0 ; i<nums1.length ; i++){
        //     for(int j=0 ; j<nums2.length ; j++){
        //         if(nums1[i] == nums2[j]){
        //             j=j+1;
        //             while(j<nums2.length){
        //                 if(nums1[i] < nums2[j]){
        //                     ans[k++] = nums2[j];
        //                     break;
        //                 }
        //                 j++;
        //             }
        //             if(j==nums2.length)
        //                 ans[k++] = -1;
        //             break;
        //         }
        //     }
        // }
        // return ans;
        
        //Method 2 sort the second array, use binary search to find next greater element
        
        Stack<Integer> smaller_Index = new Stack<>();
        HashMap<Integer, Integer> nextGreater = new HashMap<>();
        for(int ele : nums2){     
            while(!smaller_Index.isEmpty() && smaller_Index.peek() < ele){
                nextGreater.put(smaller_Index.pop(), ele);                    
            }
            smaller_Index.push(ele);
        }
        while(!smaller_Index.isEmpty()){
            nextGreater.put(smaller_Index.pop(), -1);           
        }
        int[] ans = new int[nums1.length];
        int k=0;
        for(int ele : nums1){
            ans[k++] = nextGreater.get(ele) ;
        }
        return ans;
    }
}