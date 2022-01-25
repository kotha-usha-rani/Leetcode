// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countSquares(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countSquares(int N) {
        
        //Method 1 check for each number less than queare root of N
        // double end = Math.sqrt(N);
        // int count = 0;
        // for(int i=1 ; i<end ; i++){
        //     if(i*i < N)
        //         count++;
        // }
        // return count;
        
        
        //Method 2 number of perfect squares = sqrt(n-1)
        return (int)Math.sqrt(N-1);
    }
}