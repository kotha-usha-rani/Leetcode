// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        //Method 1: find common from A and B, then find common from ans and C
        int i=0, j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<n1 && j<n2){
            if(A[i] == B[j]){
                ans.add(A[i]);
                i++;j++;
            }
            else if(A[i] < B[j])
                i++;
            else
                j++;
        }
        i=0;j=0;
        while(i<n3 && j<ans.size()){
            if(C[i] == ans.get(j)){
                i++;j++;
            }
            else if(C[i] < ans.get(j))
                i++;
            else{
                ans.remove(j);
            }
        }
        while(j< ans.size()){
            ans.remove(j);
        }
        if(ans.size()!=0){
            int prev = ans.get(0);
            for(i=1 ; i<ans.size() ;){
                if(ans.get(i) == prev)
                    ans.remove(i);
                else{
                    prev = ans.get(i);
                    i++;
                }
            }
        }
        return ans;  
    }
}