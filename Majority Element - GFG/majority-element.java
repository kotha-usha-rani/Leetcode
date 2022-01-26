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
        // your code here
        Arrays.sort(nums);
        int count = 1;
        int max = 0;
        int ele = 0 ;
        int prev = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i] == prev)
                count++;
            else{
                if(count > max){
                    max = count;
                    ele = prev ;
                }
                prev = nums[i];
                count = 1 ;
            }
        }
        if(count > max && count > size/2)
            return prev;
        if(max > size/2)
            return ele ;
        return -1;        
    }
}