// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        //Method 1 sort the array O(nlogn)+n
        // Arrays.sort(arr);
        // int step = arr[0] ;
        // int prev = 0;
        // int[] ans = new int[2];
        // ans[1] = arr[0]-1;
        // int i=0;
        // for(; i<n ; i++){
        //     if(arr[i] == prev){
        //         ans[0] = arr[i];
        //         step-- ;65
        //         i++;
        //         if(i >= n)
        //             break;
        //     }
        //     if(arr[i] != i+step){
        //         ans[1] = i+step ; 
        //         step++;
        //         i--;
        //     }
        //     prev = arr[i];
        // }
        // if(ans[1] == 0)
        //     ans[1] = i;
        // return ans;,
        
        //Method 2 consider elements as indices, mark negative for element at ele-1
        int[] ans = new int[2];
        ans[1] = 0 ;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[Math.abs(arr[i])-1] < 0){
                ans[0] = Math.abs(arr[i]);
                i++;
                if(i>=arr.length)
                    break;
            }
            arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
        }
        int i=0;
        for(; i<arr.length ; i++){
            if(arr[i] > 0){
                ans[1] = i+1 ;
                return ans;
            }
        }
        if(ans[1] == 0)
            ans[1] = i;
        return ans;
    }
}






