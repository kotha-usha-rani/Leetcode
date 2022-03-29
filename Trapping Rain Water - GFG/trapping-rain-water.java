// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        long possi = 0;
        int prev = 0;
        long total = 0 ;
        for(int i=1 ; i<n ; i++){
            if(arr[prev] > arr[i])
                possi += arr[prev] - arr[i];
            else{
                total += possi;
                prev = i;
                possi = 0 ;
            }
        }
        if(arr[n-1] < arr[prev]){
            possi = 0 ;
            int end = prev;
            prev = n-1;
            for(int i=n-2 ; i>=end ; i--){
                if(arr[prev] > arr[i])
                    possi += arr[prev] - arr[i];
                else{
                    total += possi;
                    prev = i;
                    possi = 0 ;
                }
            }
        }
        return total;
    } 
}


