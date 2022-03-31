class Solution {
    public double findM(int[] arr){
        int mid = arr.length/2;
        int m = arr[mid];
        int n = 0;
        if(arr.length % 2 == 0)
            n = arr[mid-1];
        if(arr.length%2 != 0)
            return m;
        else
            return (double)(m+n)/2.0;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0)
            return findM(nums2);
        if(nums2.length == 0)
            return findM(nums1);
        int[] arr = new int[nums1.length + nums2.length];
        int i=0;
        for(; i<nums1.length ; i++)
            arr[i] = nums1[i];
        for(i=0;i<nums2.length ; i++)
            arr[i+nums1.length] = nums2[i];
        Arrays.sort(arr);
        return findM(arr);
    }
}