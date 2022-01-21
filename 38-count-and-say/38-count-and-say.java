class Solution {
    public String countAndSay(int n) {
        //Method 1 Interation
        if(n==1)
            return "1";
       ArrayList<Integer> ans = new ArrayList<>();
       ans.add(1);
       for(int i=2 ; i<=n ; i++){
           ArrayList<Integer> temp = new ArrayList<>();
           for(int j=0 ; j<ans.size() ;){
               int count = 0 ;
               int current = ans.get(j);
               while(j<ans.size() && ans.get(j) == current){
                   count++;
                   j++;
               }
               temp.add(count);
               temp.add(current);
           }
           ans = temp ;
           
       } 
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<ans.size() ; i++){
            sb.append(ans.get(i));
        }
        return sb.toString(); 
        
    }
}