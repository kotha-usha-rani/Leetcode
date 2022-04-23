class Solution {
    public boolean isPowerOfFour(int n) {
        if(n%2 != 0 && n!= 1) return false;
        int count = 0, temp = n;
        while(n>0){
            count++;
            if(count > 1) return false;
            n = n&(n-1);
        }
        n= temp; count = 0;
        while(n>0){
            if((n&1) == 1 && count%2 == 0) return true;
            count++;
            n = n>>1;
        }
        return false;
    }
}