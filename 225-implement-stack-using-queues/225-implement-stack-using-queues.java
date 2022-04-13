class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if(!q1.isEmpty())
            q1.add(x);
        else
            q2.add(x);
    }
    
    public int pop() {
        if(!q1.isEmpty()){
            int count = q1.size();
            while(count>1){
                q2.add(q1.poll());
                count--;
            }
            return q1.poll();
        }
        else{
            int count = q2.size();
            while(count>1){
                q1.add(q2.poll());
                count--;
            }
            return q2.poll();
        }
    }
    
    public int top() {
        if(!q1.isEmpty()){
            int count = q1.size();
            while(count>1){
                q2.add(q1.poll());
                count--;
            }
            int ans = q1.poll();
            q2.add(ans);
            return ans;
        }
        else{
            int count = q2.size();
            while(count>1){
                q1.add(q2.poll());
                count--;
            }
            int ans = q2.poll();
            q1.add(ans);
            return ans;
        }
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */