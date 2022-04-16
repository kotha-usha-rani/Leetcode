class Solution {
    public int helper(String s, int index, int[] dp){
        if(index >= s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(dp[index] != -1)
            return dp[index];
        int count = 0 ;
        count += helper(s, index+1, dp);
        if(index+1 < s.length() && (s.charAt(index)-'0')*10 + (s.charAt(index+1)-'0') < 27)
            count += helper(s, index+2, dp);
        dp[index] = count;
        return dp[index];
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for(int i=0 ; i<dp.length ; i++)
            dp[i] = -1;
        return helper(s, 0, dp);
    }
}