class Solution {
    public int findDuplicate(int[] arr) {
        //Method 1 using sort
        Arrays.sort(arr);
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i] == arr[i-1])
               return arr[i];
        }
        return 0;
        
        //Method 2 using cyclic sort to sort the array
        // for(int i=0 ; i<arr.length ; i++){
        //     if(arr[i] == i+1 || arr[i] == arr[arr[i]-1])
        //         i++;
        //     else{
        //         int temp = arr[i];
        //         arr[i] = arr[arr[i]-1];
        //         arr[temp-1] = temp;
        //     }
        // }
        // return arr[arr.length-1];
        
    }
}