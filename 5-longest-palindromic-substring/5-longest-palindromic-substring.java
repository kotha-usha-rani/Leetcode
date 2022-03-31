class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int maxS = 0, maxE = 0, j=0, k=0;
        for(int i=1 ; i<s.length() ; i++){
            j=i; k=i;
            while(j-1>-1 && k+1<s.length() && s.charAt(j-1) == s.charAt(k+1)){
                j--;k++;
            }
            if(k-j+1 > maxE-maxS+1){
                maxS = j;
                maxE = k;
            }
        }
        for(int i=0 ; i<s.length()-1 ; i++){
            if(s.charAt(i) != s.charAt(i+1))
                continue;
            else{
                j=i; k=i+1;
                 while(j-1>-1 && k+1<s.length() && s.charAt(j-1) == s.charAt(k+1)){
                     j--;k++;
                 }
                 if(k-j+1 > maxE-maxS+1){
                    maxS = j;
                    maxE = k ;
                 }
            }
        }
        return s.substring(maxS, maxE+1);
    }
}