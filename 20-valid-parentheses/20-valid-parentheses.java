class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1)
            return false;
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else{
                if(st.isEmpty())
                    return false;
                if(ch == ')' && st.peek() == '(' || ch == '}' && st.peek() == '{' || ch == ']' && st.peek() == '[')
                    st.pop();
                else 
                    return false;
            }
            i++;
        }
        return st.isEmpty();
    }
}