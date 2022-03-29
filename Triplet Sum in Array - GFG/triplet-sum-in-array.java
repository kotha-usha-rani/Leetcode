// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static int getIndex(int A[], int d){
        int start = 0;
        int end =A.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(A[mid] == d)
                return mid;
            if(d < A[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
    
    public static boolean find3Numbers(int A[], int n, int X) { 
    
        //3 loops
    //   for(int i=0 ; i<n-2 ; i++){
    //       for(int j=i+1 ; j<n-1 ; j++){
    //           for(int k=j+1 ; k<n ; k++)
    //             if((A[i] + A[j] + A[k]) == X)
    //                 return true;
    //       }
    //   }
    //   return false;
    
    //sort, use binary search
    // Arrays.sort(A);
    // for(int i=0 ; i<n-1 ; i++){
    //     for(int j=i+1 ; j<n ; j++){
    //         int d = X - (A[i] + A[j]);
    //         int index = -2;
    //         if(d != A[i] && d != A[j])
    //             index = getIndex(A, d);
    //         if(index >= 0)
    //             return true;
    //     }
    // }
    // return false;
    
    //hashmap
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0 ; i<n ; i++)
        map.put(A[i], i);
    for(int i=0 ; i<n-1 ; i++){
        for(int j=i+1 ; j<n ; j++){
            int d = X - (A[i] + A[j]);
            if(d != A[i] && d != A[j])
                if(map.containsKey(d))
                    return true;
        }
    }
    return false;
    }
}








