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
        // if(nums1.length == 0)
        //     return findM(nums2);
        // if(nums2.length == 0)
        //     return findM(nums1);
        // int[] arr = new int[nums1.length + nums2.length];
        // int i=0;
        // for(; i<nums1.length ; i++)
        //     arr[i] = nums1[i];
        // for(i=0;i<nums2.length ; i++)
        //     arr[i+nums1.length] = nums2[i];
        // Arrays.sort(arr);
        // return findM(arr);
        
        if(nums1.length == 0)
            return findM(nums2);
        if(nums2.length == 0)
            return findM(nums1);
        
        int i=0, j=0, count=-1, mid=0, midP = 0, m = (nums1.length + nums2.length)/2;
        
        while(i<nums1.length && j<nums2.length){
            count++;
            if(nums1[i] <= nums2[j]){
                if(count == m){
                    mid = nums1[i];
                    break;
                }
                midP = nums1[i];
                i++;
            }
            else{
                if(count == m){
                    mid = nums2[j];
                    break;
                }
                midP = nums2[j];
                j++;
            }
        }
        while(count < m && i<nums1.length){
            count++;
            if(count == m){
                mid = nums1[i];
                break;
            }
            midP = nums1[i];
            i++;
        }
        while(count < m && j<nums2.length){
            count++;
            if(count == m){
                mid = nums2[j];
                break;
            }
            midP = nums2[j];
            j++;
        }
        
        if((nums1.length + nums2.length)%2 != 0)
            return mid;
        else
            return (double)(mid+midP)/2.0;
    }
}