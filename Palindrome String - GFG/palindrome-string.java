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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int check(String S, int i, int j){
        if(i>=j)
            return 1 ;
        if(S.charAt(i) != S.charAt(j))
            return 0;
        return check(S, i+1, j-1);
    }
    int isPalindrome(String S) {
        // code here
    //Method 1 two pointer approach
    // int len = S.length();
    // if(len == 1)
    //     return 1;
    // for(int i=0 ; i<len ; i++){
    //     if(S.charAt(i) != S.charAt(len-i-1))
    //         return 0;
    // }
    // return 1;
    // }
    
    //Method 2 Recursion
    return check(S, 0, S.length()-1);
    }
};