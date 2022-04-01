// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> help(int[][] arr, int i, int j, String path, boolean[][] track){
        ArrayList<String> ans = new ArrayList<>();
        if(i<0 || j<0 || i>=arr.length || j>=arr.length || arr[i][j] == 0 || track[i][j] == true)
            return ans;
        if(i==arr.length-1 && j== arr.length-1){
            ans.add(path);
            return ans;
        }
        track[i][j] = true;
        ans.addAll(help(arr, i-1, j, path+"U", track));
        
        ans.addAll(help(arr, i+1, j, path+"D", track));
        
        ans.addAll(help(arr, i, j-1, path+"L", track));
        
        ans.addAll(help(arr, i, j+1, path+"R", track));
        
        track[i][j] = false;
        return ans;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] track = new boolean[n][n];
        return help(m, 0, 0, "", track);
    }
}