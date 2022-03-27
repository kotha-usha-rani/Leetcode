// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        //ans is out of range
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i=2 ; i<=N ; i++){
            int r = 0;
            for(int j=ans.size()-1 ; j>=0 ; j--){
                int p = ans.get(j)*i+r;
                ans.set(j, p%10);
                r = p/10;
            }
            while(r > 0){
                ans.add(0, r%10);
                r = r/10;
            }
        }
        return ans;
    }
}