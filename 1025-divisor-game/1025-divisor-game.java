class Solution {
    public int makeMove(int n){
        if(n%2 == 0) {             //if n is even you are gonna be the winner so make sure that the opposite team member gets odd number
            int i=n/2;     
            for(; i>1 ; i-=2){        
                if(n%i == 0 && (n-i)%2 != 0)
                    return n-i;
            }
            return n-1;
        } 
        int i=(int)Math.floor(n/2);     // if n is odd you are gonna loose, so better not to waste time, end the game as soon as possible but getting the highest  
        for(; i>1 ; i-=2){        //factor using which n gets reduced as much as possible
            if(n%i == 0)
                return n-i;
        }
        return n-1;
    }
    public boolean divisorGame(int n) {
        while(n>1){
            n = makeMove(n);  //Alice turn
            if(n==1)
                return true;
            n = makeMove(n);  //bobs turn
        }
        return false;
    }
}