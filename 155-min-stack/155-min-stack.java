class MinStack {
    Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        Node newNode = null;
        if(head == null)
            newNode = new Node(val, val, null);
        else
            newNode = new Node(val, Math.min(val, head.min), head);
        head = newNode;
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
    
    class Node{
        int data;
        int min;
        Node next;
        Node(int val, int min, Node prev){
            this.data = val;
            this.min = min;
            next = prev;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */