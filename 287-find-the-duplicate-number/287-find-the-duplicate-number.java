class Solution {
    public int findDuplicate(int[] arr) {
        //Method 1 using sort
        Arrays.sort(arr);
        int prev = arr[0];
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i] == prev)
                return arr[i];
            prev = arr[i];
        }
        return prev;
        
    }
}