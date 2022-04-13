class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1, j=t.length()-1, count1 = 0, count2 = 0;
        while(i>=0 && j>=0){
            if(count1 == 0 && count2 == 0 && s.charAt(i) != '#' && t.charAt(j) != '#'){
                if(s.charAt(i) != t.charAt(j)) return false;
                else{
                    i--;j--;
                } 
                continue;
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
        return true;
    }
}