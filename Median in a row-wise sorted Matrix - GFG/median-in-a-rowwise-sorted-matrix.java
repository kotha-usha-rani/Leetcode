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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int r, int c) {
        int min = matrix[0][0];
        int max = matrix[0][c-1];
        for(int i=1 ; i<r ; i++){
            if(matrix[i][0] < min)
                min = matrix[i][0] ;
            if(matrix[i][c-1] > max)
                max = matrix[i][c-1] ;
        }
        int mid = 0;
        int temp=0;
        int req = 1+(r*c)/2;
        while(min < max){
            mid = (min+max)/2;
            int count = 0;
            for(int i=0 ; i<r ; i++){
                temp = Arrays.binarySearch(matrix[i], mid);
                if(temp >= 0){
                    while(temp < c-1){
                        if(matrix[i][temp+1] != mid)
                            break;
                        temp++;
                    }
                    count = count + temp + 1 ;
                }
                else
                    count = count + Math.abs(temp) - 1 ;
            }
            if(count < req)
                min = mid+1;
            else
                max = mid ;
        }
        return min ;
    }
}