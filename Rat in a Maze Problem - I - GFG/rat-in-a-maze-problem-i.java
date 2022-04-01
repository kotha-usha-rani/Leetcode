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
    public static ArrayList<String> help(int[][] arr, int i, int j, String path, int[] di, int[] dj){
        ArrayList<String> ans = new ArrayList<>();
        if(i<0 || j<0 || i>=arr.length || j>=arr.length || arr[i][j] == 0 || arr[i][j] == 2)
            return ans;
        if(i==arr.length-1 && j== arr.length-1){
            ans.add(path);
            return ans;
        }
        arr[i][j] = 2 ;
        String p = "UDLR";
        for(int k=0 ; k<4 ; k++)
            ans.addAll(help(arr, i+di[k], j+dj[k], path+p.charAt(k), di, dj));
         arr[i][j] = 1 ;
        return ans;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        //boolean[][] track = new boolean[n][n];
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        return help(m, 0, 0, "", di, dj);
    }
}