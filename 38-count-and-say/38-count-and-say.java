class Solution {
    
    public StringBuilder cAS(int temp, int n, StringBuilder current){
        if(temp > n)
            return current;
        StringBuilder smallAns = new StringBuilder();
        for(int i=0 ; i<current.length() ;i++){
            int count = 1;
            while(i+1<current.length() && current.charAt(i+1) == current.charAt(i)){
                count++;
                i++;
            }
            smallAns.append(count).append(current.charAt(i));
        }
        return cAS(temp+1, n, smallAns);
        
    }
    
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        
        //Method 1 Interation store the current answer, count and create a new answer, update           //the original/current answer
       // ArrayList<Integer> ans = new ArrayList<>();
       // ans.add(1);
       // for(int i=2 ; i<=n ; i++){
       //     ArrayList<Integer> temp = new ArrayList<>();
       //     for(int j=0 ; j<ans.size() ;){
       //         int count = 0 ;
       //         int current = ans.get(j);
       //         while(j<ans.size() && ans.get(j) == current){
       //             count++;
       //             j++;
       //         }
       //         temp.add(count);
       //         temp.add(current);
       //     }
       //     ans = temp ;
       // } 
       //  StringBuilder sb = new StringBuilder();
       //  for(int i=0 ; i<ans.size() ; i++){
       //      sb.append(ans.get(i));
       //  }
       //  return sb.toString(); 
        
        //Recursion
    
        return cAS(2, n, new StringBuilder("1")).toString();
    }
}