// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean checkPalindrome(String S, int start, int end){
    	int i=start ; int j=end;
        while(i<j){
            if(S.charAt(i) != S.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    static String longestPalin(String s){
        // code here
       String ans = "";
        int max = 0 ;
        for(int i=0 ; i<s.length() ; i++){
            for(int j=i ; j<s.length() ; j++){
                int len = j-i+1;
                if(len > max && checkPalindrome(s, i, j)){
                    if(len > max)
                        max = len;
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans ;
        
    }
}