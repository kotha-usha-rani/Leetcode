//Method 1 using Node with val, min, next
// class MinStack {
//     Node head;
//     public MinStack() {
//         head = null;
//     }
    
//     public void push(int val) {
//         Node newNode = null;
//         if(head == null)
//             newNode = new Node(val, val, null);
//         else
//             newNode = new Node(val, Math.min(val, head.min), head);
//         head = newNode;
//     }
    
//     public void pop() {
//         head = head.next;
//     }
    
//     public int top() {
//         return head.data;
//     }
    
//     public int getMin() {
//         return head.min;
//     }
    
//     class Node{
//         int data;
//         int min;
//         Node next;
//         Node(int val, int min, Node prev){
//             this.data = val;
//             this.min = min;
//             next = prev;
//         }
//     }
// }


//Method 2 using 2 stacks // arraylists for dynamic arrays
class MinStack {
    ArrayList<Integer> data;
    ArrayList<Integer> minData;
    public MinStack() {
       data = new ArrayList<>();
        minData = new ArrayList<>();
    }
    
    public void push(int val) {
       data.add(val);
        if(minData.size() == 0)
            minData.add(val);
        else
            minData.add(Math.min(minData.get(minData.size()-1), val));
    }
    
    public void pop() {
        data.remove(data.size()-1);
        minData.remove(minData.size()-1);
    }
    
    public int top() {
       return data.get(data.size()-1);
    }
    
    public int getMin() {
        return minData.get(minData.size()-1);
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