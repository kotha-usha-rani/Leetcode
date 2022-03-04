class Solution {
    public int findDuplicate(int[] arr) {
        //Method 1 using sort
        // Arrays.sort(arr);
        // for(int i=1 ; i<arr.length ; i++){
        //     if(arr[i] == arr[i-1])
        //        return arr[i];
        // }
        // return 0;
        
        //Method 2 using cyclic sort to sort the array
        for(int i=0 ; i<arr.length ; ){
            int index = arr[i]-1;
            if(arr[i] != arr[index]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
            else
                i++;
        }
        return arr[arr.length-1];
    }
}