// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int v[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < N; j++) v[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            int ans[][] = ob.sortedMatrix(N, v);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] sort(int[] arr1, int[] arr2){
        int[] ans = new int[arr1.length+arr2.length];
        int i=0 ; int j=0; int k=0;
        while(i<arr1.length && j< arr2.length){
            if(arr1[i] <= arr2[j])
                ans[k++] = arr1[i++];
            else
                ans[k++] = arr2[j++];
        }
        while(i<arr1.length){
            ans[k++] = arr1[i++];
        }
        while(j<arr2.length){
            ans[k++] = arr2[j++];
        }
        return ans;
    }
    
    int[] mergeSort(int[][] mat, int start, int end){
        if(start == end){
            Arrays.sort(mat[start]);
            return mat[start];
        }
        int mid = (start+end)/2;
        int[] arr1 = mergeSort(mat, start, mid);
        int[] arr2 = mergeSort(mat, mid+1, end);
        return sort(arr1, arr2);
    }
    
    int[][] sortedMatrix(int N, int Mat[][]) {
        //method 2 using merge sort
        int[] ans = mergeSort(Mat, 0, N-1);
        int k = 0;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++)
                Mat[i][j] = ans[k++];
        }
        return Mat ;
    }
};