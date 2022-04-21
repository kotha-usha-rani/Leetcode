class Solution {
    public String reverseWords(String s) {
        // StringBuilder sb = new StringBuilder();
        // for(int i=s.length()-1 ; i>=0 ; i--){
        //     if(s.charAt(i) == ' ')
        //         continue;
        //     int j=i;
        //     while(j>=0 && s.charAt(j) != ' '){
        //         j--;
        //     }
        //     sb.append(s.substring(j+1, i+1));
        //     sb.append(' ');
        //     i=j;
        // }
        // if(sb.charAt(sb.length()-1) == ' ')
        //     sb.deleteCharAt(sb.length()-1);
        // return sb.toString();
        
        
        String[] strs = s.trim().split("\\s+");
        int i=0, j=strs.length-1;
        while(i<j){
            String temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
            i++;j--;
        }
        return String.join(" ", strs);
    }
}