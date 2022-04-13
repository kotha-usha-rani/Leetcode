class Solution {
    public Stack<Character> getString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i) == '#'){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(s.charAt(i));
        }
        return stack;
    }
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }
}