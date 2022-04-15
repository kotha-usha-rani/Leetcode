class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = -1;
        right[heights.length-1] = heights.length;
        int prev = 0;
        for(int i=1 ; i<heights.length ; i++){
            prev = i-1;
            while(prev >= 0 && heights[prev] >= heights[i])
                prev = left[prev];
            left[i] = prev;
        }
        for(int i=heights.length-2 ; i>=0 ; i--){
            prev = i+1;
            while(prev < heights.length && heights[prev] >= heights[i])
                prev = right[prev];
            right[i] = prev;
        }
        int max = 0;
        for(int i=0 ; i<heights.length ; i++)
            max = Math.max(max, (right[i]-left[i]-1) * heights[i]);
        return max;
    }
}