// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthPosition(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
    static long nthPosition(long n){
        if(n==1)
            return 0;
        int i=2, ans = 0;
        while(i<=n){
            if((i&(i-1)) == 0)
            ans = i;
            i*=2;
        }
        return ans;
    }
}