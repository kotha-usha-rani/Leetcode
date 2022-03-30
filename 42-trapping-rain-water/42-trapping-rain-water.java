class Solution {
    public int trap(int[] arr) {
        // int possi = 0;
        // int prev = 0;
        // int total = 0 ;
        // for(int i=1 ; i<arr.length ; i++){
        //     if(arr[prev] > arr[i])
        //         possi += arr[prev] - arr[i];
        //     else{
        //         total += possi;
        //         prev = i;
        //         possi = 0 ;
        //     }
        //}
        //if the last block is bigger than prev block then possi was added in the above else block but
        //if the last block is smaller than the prev block then the total amount of water collected will
        //be according to the bigger block which is not the case as we are supposed to calculate the 
        //trapped water between the blocks, so start from the last block calculate until the prev block
        // if(arr[arr.length-1] < arr[prev]){
        //     possi = 0 ;
        //     int end = prev;
        //     prev = arr.length-1;
        //     for(int i=arr.length-2 ; i>=end ; i--){
        //         if(arr[prev] > arr[i])
        //             possi += arr[prev] - arr[i];
        //         else{
        //             total += possi;
        //             prev = i;
        //             possi = 0 ;
        //         }
        //     }
        // }
        // return total;
    
    //two pointer method
        int low = arr[0] ;
        int high = arr[arr.length-1];
        int total = 0 ;
        int l=1, h=arr.length-2;
        while(l<=h){
            if(low < high){
                if(arr[l] < low)
                    total += low - arr[l];
                else
                    low = arr[l]; 
                l++;
            }
            else{
                if(arr[h] < high)
                    total += high - arr[h];
                else
                    high = arr[h];
                h--;
            }
        }
        return total;
    }
}