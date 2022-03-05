// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}// } Driver Code Ends


class Solution {

    public void swap(int[] arr1, int[] arr2, int i, int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    
    // public void sortIn(int[] arr1, int[] arr2, int start, int end){
        
    // }
    public void merge(int arr1[], int arr2[], int n, int m) {
        //method 3 using gap algorithm
        int i, j, gap, temp;
        Boolean isIinArr2, isJinArr1;
        gap = m+n;
        while(gap != 1){
            isJinArr1 = false;
            if(gap%2 != 0)
                gap = (int)Math.ceil(gap/2.0);
            else
                gap = gap/2;
            i=0;
            if(gap > n-1)
                j = gap-n ;
            else{
                j = gap;
                isJinArr1 = true;
            }
            isIinArr2 = false;
            if(isJinArr1){
                while(j<n){
                    if(arr1[i] > arr1[j])
                        swap(arr1, arr1, i, j);
                    i++;j++;
                }
                j=0; isJinArr1 = false;
            }  
            if(!isIinArr2){
                while(i < n && j<m){
                    if(arr1[i] > arr2[j])
                        swap(arr1, arr2, i, j);
                    i++;j++;
                }
                i=0; isIinArr2 = true;
            }
            while(j<m){
                if(arr2[i] > arr2[j])
                    swap(arr2, arr2, i, j);
                i++; j++;
            }
            
        }
    }
}