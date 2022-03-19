class Solution {
    
    public int solution(int n, int[] memo){
        if(n<0)
            return 0;
        if(memo[n] != -1)
            return memo[n];
        memo[n] = solution(n-1, memo) + solution(n-2, memo);
        return memo[n];
    }
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        for(int i=0 ; i<n+1 ; i++)
            memo[i] = -1;
        memo[0] = 1;
        memo[1] = 1;
        return solution(n, memo);
    }
}