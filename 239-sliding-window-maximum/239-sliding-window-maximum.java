class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair2.val, pair1.val));
        for(int i=0 ; i<k ; i++){
            heap.add(new Pair(nums[i], i));
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = heap.peek().val;
        int j=1;
        for(int i=1 ; i<=nums.length-k ; i++){
            while(!heap.isEmpty() && heap.peek().index < i){
                heap.poll();
            }
            heap.add(new Pair(nums[i+k-1], i+k-1));
            ans[j++] = heap.peek().val;
        }
        return ans;
    }
}
class Pair{
    int val;
    int index;
    Pair(int val, int index){
        this.val = val;
        this.index = index;
    }
}