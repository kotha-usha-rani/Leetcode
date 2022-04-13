class MyQueue {
    Stack<Integer> stk1 ;
    Stack<Integer> stk2 ;
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void push(int x) {
        stk1.push(x);
    }
    
    public int pop() {
        if(stk1.isEmpty())
            return -1;
        while(!stk1.isEmpty())
            stk2.push(stk1.pop());
        int ans = stk2.pop();
        while(!stk2.isEmpty())
            stk1.push(stk2.pop());
        return ans;
    }
    
    public int peek() {
        if(stk1.isEmpty())
            return -1;
        while(!stk1.isEmpty())
            stk2.push(stk1.pop());
        int ans = stk2.peek();
        while(!stk2.isEmpty())
            stk1.push(stk2.pop());
        return ans;
    }
    
    public boolean empty() {
        return stk1.isEmpty() ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */