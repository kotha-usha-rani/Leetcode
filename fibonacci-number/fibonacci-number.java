class Solution {
    public int solution(int n, int[] memo){
        if(n<2)
            return n;
        if(memo[n] != -1)
            return memo[n];
        memo[n] = solution(n-2, memo) + solution(n-1, memo);
        return memo[n];
    }
    public int fib(int n) {
        if(n < 2)
            return n;
        int[] memo = new int[n+1];
        for(int i=0 ; i<n+1 ; i++)
            memo[i] = -1;
        return solution(n, memo);
    }
}