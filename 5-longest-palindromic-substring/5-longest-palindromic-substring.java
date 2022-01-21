class Solution {
        public int min = 0;
        boolean checkPalindrome(String S, int start, int end){
    	int i=start ; int j=end;
        while(i<j){
            if(S.charAt(i) != S.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0 ;
        for(int i=0 ; i<s.length() ; i++){
            for(int j=i ; j<s.length() ; j++){
                int len = j-i+1;
                if(len > max && checkPalindrome(s, i, j)){
                    if(len > max)
                        max = len;
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans ;
    }
}