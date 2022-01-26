// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int size)
    {
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
        // if(count > max && count > size/2)
        //     return prev;
        // if(max > size/2)
        //     return ele ;
        // return -1;   
        
        //HashMap to store the count of elements--> time limit exceeded
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
              map.put(nums[i], map.get(nums[i])+1);
              if(map.get(nums[i]) > size/2)
                return nums[i];
            }
            else
              map.put(nums[i], 1);
        }
        for(Integer ele : map.keySet()){
            if(map.get(ele) > size/2)
                return ele;
        }
        return -1;
    }
}