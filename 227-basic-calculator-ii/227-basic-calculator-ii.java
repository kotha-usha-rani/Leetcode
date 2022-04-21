class Solution {
    public int calculate(String s) {
        int num = 0;
        char oper = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            if(Character.isDigit(s.charAt(i)))
                num = num*10 + (s.charAt(i)-'0');
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '|| i==s.length()-1){
                System.out.println(num);
                if(oper == '-')
                    stack.push(-num);
                else if(oper == '+')
                    stack.push(num);
                else if(oper == '*')
                    stack.push(stack.pop()*num);
                else 
                    stack.push(stack.pop()/num);
                
                num = 0;
                oper = s.charAt(i);
            }
        }
        num = 0;
        while(!stack.isEmpty())
            num += stack.pop();
        return num;
    }
}