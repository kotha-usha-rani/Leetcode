class Solution {
    public List<String> helper(int left, int right, String s){
        List<String> ans = new ArrayList<>();
        if(left > right || left < 0 || right < 0 || right < left)
            return ans;
        if(left == 0 && right == 0){
            ans.add(s);
            return ans;
        }
        ans.addAll(helper(left-1, right, s+"("));
        ans.addAll(helper(left, right-1, s+")"));
        return ans;
    }
    public List<String> generateParenthesis(int n) {
        return helper(n, n, "");
    }
}