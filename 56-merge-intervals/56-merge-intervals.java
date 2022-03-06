class Solution {
    public int[][] merge(int[][] arr) {
        //Method 1: sort the array, find the intervals
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int i=0, j, max, k=0;
        ArrayList<int[]> tempAns = new ArrayList<>();
        while(i<arr.length){
            j=i;
            max = arr[i][1];
            while(j+1 < arr.length && max >= arr[j+1][0]){
                max = Math.max(max, arr[j+1][1]);
                j++;
            }
            tempAns.add(new int[]{arr[i][0], max});
            i = j+1;            
        }
        //int[][] ans = new int[tempAns.size()/2][2];
        return tempAns.toArray(new int[tempAns.size()/2][2]);
    }
}