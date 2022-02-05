// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
       //Method 1 using two loops
        for(int i=0 ; i<n ; i++){
            int j=0;
            if(i==0)
                j = 1 ;
            if(j<n && arr[j][i] == 1){
                while(j<n){
                    if(arr[i][j] != 0)
                        break;
                    j++;
                }
            }
            if(j==n)
                return i ;
        }
        return -1;
    
    
    //Method 2 using two arrays of size n
        // int[] count = new int[n];
        // for(int i=0 ; i<n ; i++){
        //     for(int j=0 ; j<n ; j++){
        //         if(arr[i][j] == 1 && arr[j][i] != 1){
        //             count[j]++;
        //         }
        //     }
        // }
        // for(int i=0 ; i<n ; i++){
        //     if(count[i] == n-1)
        //         return i;
        // }
        // return -1;
    }
}