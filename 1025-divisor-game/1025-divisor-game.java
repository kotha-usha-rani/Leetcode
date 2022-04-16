class Solution {
    public int makeMove(int n){
        if(n%2 == 0)
            return n-1;
        int i=n/2;
        if(i%2 == 0)
            i++;
        for(; i>=1 ; i-=2){
            if(n%i == 0)
                return n-i;
        }
        return 1;
    }
    public boolean divisorGame(int n) {
        while(n>1){
            n = makeMove(n);
            if(n==1)
                return true;
            n = makeMove(n);
        }
        return false;
    }
}