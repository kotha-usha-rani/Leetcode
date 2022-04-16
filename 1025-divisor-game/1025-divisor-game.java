class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[10001];
        for(int i=2 ; i<=n ; i++){          //start with 2 as n=1 is false anyways
            for(int j=1 ; j<i ; j++){
                if(i%j == 0 && !dp[i-j]){     // to check the factors of i and if i-j leads to an odd number to 
                    dp[i] = true;             //make sure that bob get odd i.e, dp[i-j] == false (a false is an odd 
                    break;                    //number accoding to our solution) and alice wins
                }                             //if dp[i] is not set to true, indicates that it is an odd number and 
            }                                 //alice looses
        }
        return dp[n];
    }
}