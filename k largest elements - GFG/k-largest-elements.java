// { Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        //sort the array, return k largest elements
        // int[] ans = new int[k];
        // Arrays.sort(arr);
        // int j=0;
        // for(int i=n-1 ; i>=n-k ; i--)
        //     ans[j++] = arr[i];
        // return ans;
        
        //using maxheap 
        // PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0 ; i<n ; i++)
        //     heap.add(arr[i]);
        // int[] ans = new int[k];
        // for(int i=0 ; i<k ; i++)
        //     ans[i] = heap.remove();
            
        // return ans;
        
        //using minheap, store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i=0;
        for(; i<k ; i++){
            minHeap.add(arr[i]);
        }
        for( i=k ; i<n ; i++){
            if(minHeap.peek() < arr[i]){
                minHeap.remove();
                minHeap.add(arr[i]);
            }
        }
        int[] ans = new int[k];
        i=k;
        while(!minHeap.isEmpty()){
            ans[--k] = minHeap.remove();
        }
        return ans;
    }
}





