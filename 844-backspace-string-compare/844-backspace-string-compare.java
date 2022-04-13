class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(t);
        boolean ans1 = false, ans2 = false;
        int i=0, j=0;
        while(i<sb1.length() || j<sb2.length()){
            if(i<sb1.length() && sb1.charAt(i) == '#'){
                if(!sb1.isEmpty()){
                    sb1.deleteCharAt(i);
                    if(i>0){
                        sb1.deleteCharAt(i-1); i= i-1;
                    }
                }
                else
                    ans1 = true;    
            }
            else
                i++;
            if(j<sb2.length() && sb2.charAt(j) == '#'){
                if(!sb2.isEmpty()){
                    sb2.deleteCharAt(j);
                    if(j>0){
                        sb2.deleteCharAt(j-1); j=j-1;
                    }
                }
                else
                    ans2 = true;
            }
            else
                j++;
            if(ans1 && ans2)
                return true;
        }
        if(sb1.length() != sb2.length())
            return false;
        for(i=0 ;i<sb1.length() ; i++){
            if(sb1.charAt(i) != sb2.charAt(i))
                return false;
        }
        return true;
    }
}