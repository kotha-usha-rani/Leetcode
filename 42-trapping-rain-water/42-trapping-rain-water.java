class Solution {
    public int trap(int[] arr) {
        int possi = 0;
        int prev = 0;
        int total = 0 ;
        for(int i=1 ; i<arr.length ; i++){
            if(arr[prev] > arr[i])
                possi += arr[prev] - arr[i];
            else{
                total += possi;
                prev = i;
                possi = 0 ;
            }
        }
        if(arr[arr.length-1] < arr[prev]){
            possi = 0 ;
            int end = prev;
            prev = arr.length-1;
            for(int i=arr.length-2 ; i>=end ; i--){
                if(arr[prev] > arr[i])
                    possi += arr[prev] - arr[i];
                else{
                    total += possi;
                    prev = i;
                    possi = 0 ;
                }
            }
        }
        return total;
    }
}