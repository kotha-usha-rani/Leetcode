class Solution {
    public void reverseString(char[] s) {
        //Method 1 using two pointer approach
        for(int i=0 ; i<s.length/2 ; i++){
            char ch = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = ch;
        }
    }
}