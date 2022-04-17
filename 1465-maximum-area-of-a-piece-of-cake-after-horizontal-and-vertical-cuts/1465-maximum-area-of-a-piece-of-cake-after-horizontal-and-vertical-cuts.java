class Solution {
    public int getDistance(int[] arr, int len){
        int max = arr[0];
        for(int i=1 ; i<arr.length ; i++)
            max = Math.max(max, arr[i] - arr[i-1]);
        max = Math.max(max, len - arr[arr.length-1]);
        return max;
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long mod = 1000000000 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxDH = getDistance(horizontalCuts, h), maxVH = getDistance(verticalCuts, w);
        return (int)((long)maxDH*maxVH%mod);
    }
}