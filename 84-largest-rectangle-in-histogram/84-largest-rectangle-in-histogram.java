class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = 0;
        right[heights.length-1] = heights.length-1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1 ; i<heights.length ; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.isEmpty()) left[i] = 0;
            else left[i] = stack.peek()+1;
            stack.push(i);
        }
        while(!stack.isEmpty())
            stack.pop();
        stack.push(heights.length-1);
        for(int i=heights.length-2 ; i>=0 ; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.isEmpty()) right[i] = heights.length-1;
            else right[i] = stack.peek()-1;
            stack.push(i);
        }
        int max = 0;
        for(int i=0 ; i<heights.length ; i++)
            max = Math.max(max, (right[i]-left[i]+1) * heights[i]);
        return max;
    }
}