// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        //Method 1 : linear search for every element
        // int count = 0 ;
        // for(int i=0 ; i<n-1 ; i++){
        //     for(int j=i+1 ; j<n ; j++){
        //         if(arr[i]+arr[j] == k)
        //             count++;
        //     }
        // }
        // return count;
        
        //method 2 : using hashmaps
        // if(n==1 || k==1)
        //     return 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int count =0 ;
        // for(int i=0 ; i<n ; i++){
        //     if(map.containsKey(arr[i]))
        //         map.put(arr[i], map.get(arr[i])+1);
        //     else
        //         map.put(arr[i], 1);
        // }
        // for(int i=0 ; i<n ; i++){
        //     int ele = k-arr[i];
        //     if(map.containsKey(arr[i]) && map.containsKey(ele) && map.get(ele) > 0){
        //         int temp = map.get(ele);
        //         if(ele == arr[i]){
        //             count += (temp-1);
        //             map.put(ele, temp-1);
        //         }
        //         else{
        //             count += (temp*map.get(arr[i]));
        //             // map.put(arr[i], 0);
        //             // map.put(ele, 0);
        //             map.remove(arr[i]);
        //             map.remove(ele);
        //         }
        //     }
        // }
        // return count;
        
        //Method 2 : shot code
        // if(n==1 || k==1)
        //     return 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int count =0 ;
        // for(int i=0 ; i<n ; i++){
        //     if(map.containsKey(arr[i]))
        //         map.put(arr[i], map.get(arr[i])+1);
        //     else
        //         map.put(arr[i], 1);
        // }
        // for(int i=0 ; i<n ; i++){
        //     if(map.get(k-arr[i]) != null){
        //         count += map.get(k-arr[i]);
        //         if(k-arr[i] == arr[i])
        //             count--;
        //     }
        // }
        // return count/2;
        
        //Method 3: hashmap using one loop
        // int count = 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0 ; i<arr.length ; i++){
        //     if(map.get(k-arr[i]) != null){
        //         count += map.get(k-arr[i]);
        //     }
        //     if(map.containsKey(arr[i])){
        //         map.put(arr[i], map.get(arr[i])+1);
        //     }
        //     else
        //         map.put(arr[i], 1);
        // }
        // return count;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int diff, count = 0 ;
        for(int i=0 ; i<n ; i++){
            diff = k-arr[i];
            if(map.containsKey(diff)){
                count+=map.get(diff);
            }
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else
                map.put(arr[i], 1);
        }
        return count;
    }
}
