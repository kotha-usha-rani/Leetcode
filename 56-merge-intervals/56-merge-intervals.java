class Solution {
    public int[][] merge(int[][] arr) {
        //Method 1: sort the array, find the intervals
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int i=0, j, max, k=0;
        ArrayList<Integer> tempAns = new ArrayList<>();
        while(i<arr.length){
            j=i;
            max = arr[i][1];
            while(j+1 < arr.length && max >= arr[j+1][0]){
                max = Math.max(max, arr[j+1][1]);
                j++;
            }
            tempAns.add(arr[i][0]);
            tempAns.add(max);
            i = j+1;            
        }
        int[][] ans = new int[tempAns.size()/2][2];
        for(i=0 ; i<tempAns.size() ; i+=2){
            ans[k][0] = tempAns.get(i);
            ans[k++][1] = tempAns.get(i+1);
        }
        return ans;
    }
}