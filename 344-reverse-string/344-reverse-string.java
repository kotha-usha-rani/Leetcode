class Solution {
    public void reverse(char[] s, int i, int j){
        if(i>=j)
            return;
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
        reverse(s, i+1, j-1);
    }
    public void reverseString(char[] s) {
        //Method 1 using two pointer approach
        // for(int i=0 ; i<s.length/2 ; i++){
        //     char ch = s[i];
        //     s[i] = s[s.length-i-1];
        //     s[s.length-i-1] = ch;
        // }
        
        //Method 2 using recursion
        reverse(s, 0, s.length-1);
    }
}