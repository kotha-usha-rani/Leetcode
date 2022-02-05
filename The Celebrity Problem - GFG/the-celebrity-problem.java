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
    // 	for(int i=0 ; i<n ; i++){
    // 	    for(int j=0 ; j<n ; j++){
    // 	        if(arr[j][i] == 1 && arr[i][j] != 1){
    // 	            int k = 0 ;
    // 	            boolean isCelebrity = true;
    // 	            while(k<n){
    // 	                if(arr[i][k] == 1){
    // 	                    isCelebrity = false;
    // 	                    break;
    // 	                }
    // 	                k++;
    // 	            }
    // 	            if(isCelebrity)
    // 	                return i ;
    // 	            else
    // 	                break;
    // 	        }
    // 	    }
    // 	}
    // 	return -1;
    
    
    //Method 2 using two arrays of size n
        int[] count = new int[n];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(arr[i][j] == 1){
                    count[j]++;
                }
            }
        }
        for(int i=0; i<n ; i++){
            int j=0;
            while(count[i] >= n-1 && j<n){
                if(arr[i][j] == 1)
                    count[i]--;
                j++;
            }
        }
        for(int i=0 ; i<n ; i++){
            if(count[i] == n-1)
                return i;
        }
        return -1;
    }
}