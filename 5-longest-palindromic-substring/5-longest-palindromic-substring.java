class Solution {
    public void findSE(String s, int j, int k, Pair SE){
        while(j-1>-1 && k+1<s.length() && s.charAt(j-1) == s.charAt(k+1)){
                j--;k++;
            }
            if(k-j+1 > SE.maxE-SE.maxS+1){
                SE.maxS = j;
                SE.maxE = k;
            }
    }
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int maxS = 0, maxE = 0, j=0, k=0;
        Pair SE = new Pair(0, 0);
        for(int i=1 ; i<s.length() ; i++){
            j=i; k=i;
            findSE(s, j, k, SE);
        }
        for(int i=0 ; i<s.length()-1 ; i++){
            if(s.charAt(i) != s.charAt(i+1))
                continue;
            else{
                j=i; k=i+1;
                findSE(s, j, k, SE);
            }
        }
        return s.substring(SE.maxS, SE.maxE+1);
    }
}
class Pair{
    int maxS;
    int maxE;
    Pair(int maxS, int maxE){
        this.maxS = maxS;
        this.maxE = maxE;
    }
}