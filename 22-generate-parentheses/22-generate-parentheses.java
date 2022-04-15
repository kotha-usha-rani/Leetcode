class Solution {
    public void helper(int n, StringBuilder sb, HashSet<String> set){
        if(n==1){
            set.add(new String(sb.toString()));
            return;
        }
        for(int i=0 ; i<(sb.length()/2)+1 ; i++){
            sb.insert(i, "()");
            helper(n-1, sb, set);
            sb.delete(i, i+2);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n==1){
            ans.add("()");
            return ans;
        }
        HashSet<String> set = new HashSet<>();
        helper(n, new StringBuilder("()"), set);
        for(String s : set)
            ans.add(s);
        return ans;
    }
}