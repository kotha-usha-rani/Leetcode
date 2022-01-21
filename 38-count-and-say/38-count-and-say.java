class Solution {
    
    public ArrayList<Integer> cAS(int temp, int n, ArrayList<Integer> current){
        if(temp > n)
            return current;
        ArrayList<Integer> smallAns = new ArrayList<>();
        for(int i=0 ; i<current.size() ;){
            int ch = current.get(i);
            int count = 0;
            while(i<current.size() && current.get(i) == ch){
                count++;
                i++;
            }
            smallAns.add(count);
            smallAns.add(ch);
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
        ArrayList<Integer> current = new ArrayList<>();
        current.add(1);
        current = cAS(2, n, current);
        StringBuilder ans = new StringBuilder();
        for(int i=0 ; i<current.size() ; i++){
            ans.append(current.get(i));
        }
        return ans.toString();
    }
}