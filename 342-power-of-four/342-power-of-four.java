class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1)
            return true;
        if((n&1) == 1 || (n&(n-1)) != 0) return false;
        while(n>0){
            if(n == 1) return true;
            n = n>>2;
        }
        return false;
    }
}