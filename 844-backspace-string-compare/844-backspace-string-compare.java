class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1, j=t.length()-1, count1 = 0, count2 = 0;
        while(i>=0 && j>=0){
            if(count1 == 0 && count2 == 0 && s.charAt(i) != '#' && t.charAt(j) != '#'){
                if(s.charAt(i) != t.charAt(j)) return false;
                else{
                    i--;j--;
                } 
                continue;    // to avoid index out of bounds, if you don't want to use continue, use checks (i>=0 || j>=0) in every if conditions below
            }
            if(s.charAt(i) == '#'){
                count1++; i--;
            }
            else if(count1 > 0){
                i--; count1--;
            }
            if(t.charAt(j) == '#'){
                count2++; j--;
            }
            else if(count2 > 0){
                j--; count2--;
            }
        }
        //to check if any string has leftover characters Note: comparisions in both the strings might be exhausted, or one of the string's is exhausted
        //therefore check for the string which has characters to compare "remember that presence of '#' will cancel out the alphabets and might lead to equal strings" 
        //if there is a string with alphabets without "#" after them will not be equal strings (this will not apply to the above while loop) 
        //hence the need of this checks is to cancel out all the remaining alphabets
        if(i>=0){
            if(s.charAt(i) != '#'){
                if(count1 > 0) count1--;
                else return false;
            }
            else count1++;
            i--;
        }
        if(j>=0){
            if(t.charAt(j) != '#'){
                if(count2 > 0) count2--;
                else return false;
            }
            else count2++;
            j--;
        }
        
        //if all the characters are equal
        return true;
    }
}