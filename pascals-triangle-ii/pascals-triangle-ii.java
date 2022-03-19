class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0)
            return new ArrayList<>(){
            {
                add(1);
            }
        };
        // if(rowIndex == 1)
        //     return new ArrayList<>(){
        //     {
        //         add(1);
        //         add(1);
        //     }
        // };
        
        List<Integer> smallAns = getRow(rowIndex-1);
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i=1 ; i<smallAns.size() ; i++){
            ans.add(smallAns.get(i-1)+smallAns.get(i));
        }
        ans.add(1);
        return ans;
    }
}