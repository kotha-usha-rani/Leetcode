class Solution {
    //Method 1 using recursion, time limit exceeded
    static int findSum(int[] arr, int start, int[] results){
        if(arr.length == 1)
			return 0;
		if(start >= arr.length-1)
			return 0 ;
		int min = Integer.MAX_VALUE;
		int maxSteps = arr[start];
		if(results[start] != -2)
		    return results[start];
		while(maxSteps > 0){
			int ans = 1+findSum(arr, start + maxSteps, results);
			if(ans > 0)
				min = Math.min(ans, min);
			maxSteps--;
		}
		results[start] = min;
		return min ;
    } 
    public int jump(int[] arr) {
        //Method 1 using recursion, time limit exceeded
        int[] results = new int[arr.length];
        for(int i=0 ; i<arr.length ; i++)
            results[i] = -2;
        int ans = findSum(arr, 0, results) ;
        if(ans < arr.length)
            return ans;
        return -1;
    }
}