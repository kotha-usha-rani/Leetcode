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
    int celebrity(int M[][], int n)
    {
    	//brute force
    // 	int count;
    // 	for(int i=0 ; i<n ; i++){
    // 	    count = 0;
    // 	    if(i!= 0 && M[0][i] == 0)
    // 	        continue;
    // 	    for(int j=0 ; j<n ; j++){
    // 	        if(i==j)
    // 	            continue;
    // 	        if(M[j][i] != 1)
    // 	            break;
    // 	        else{
    // 	            if(M[i][j] == 1){
    // 	                if(j==i+1)
    // 	                    i+=1;
    // 	                break;
    // 	            }
    // 	            else
    // 	                count++;
    // 	        }
    // 	    }
    // 	    if(count == n-1)
    // 	        return i;
    // 	}
    // 	return -1;
    
    //using count array
    int[] count = new int[n];
        for(int i=0 ; i<n ; i++){
            if(i!=0 && M[0][i] == 0){
                count[i] = 0 ;
                continue;
            }
            for(int j=0 ; j<n ; j++){
                if(M[j][i] == 1 && M[i][j] != 1)
                    count[i]++;
            }
        }
        for(int i=0 ; i<n ; i++){
            if(count[i] == n-1)
                return i;
        }
        return -1;
    }
}