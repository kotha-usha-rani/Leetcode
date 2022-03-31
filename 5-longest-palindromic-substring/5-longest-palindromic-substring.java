class Solution {
    
    public int findSE(String s, int j, int k){
        while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)){
                j--;k++;
        }
        return k-j-1;
    }
    
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int maxS = 0, maxE = 0;
        for(int i=0 ; i<s.length() ; i++){
            int odd = findSE(s, i, i);
            int even = findSE(s, i, i+1);
            if(maxE < Math.max(odd, even)){
               maxS = odd > even ? i-odd/2 : i-even/2+1;
               maxE = Math.max(odd, even);
            }
        }
        return s.substring(maxS, maxS+maxE);
    }
}