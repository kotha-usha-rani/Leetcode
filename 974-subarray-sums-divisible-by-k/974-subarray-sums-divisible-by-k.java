class Solution {
    public int subarraysDivByK(int[] nums, int k) {
//         4 5 0 -2 -3 1
//           |-| -> s1 = kn+x where k is given k, n is number of elements from 5 to 0, and x is the remainder of sum/k
//           |-------|   -> s2 = km + x where m is number of elments from 5  to -3
            
//         sum of numbers from -2 to -3 is = s1-s2
//         i.e, kn+x - km - x
//              = kn-km
//              = k(n-m) which is divisible by k
//         store the remainderes in a hashmap, if a remainder is repeated then count that subarray
        
        //using hashmap
        // HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0, 1);
        // int sum = 0, count = 0;;
        // for(int i=0 ; i<nums.length ; i++){
        //     sum += nums[i];
        //     int rem = sum % k;
        //     if(rem < 0) rem += k;
        //     if(map.containsKey(rem)){
        //         count += map.get(rem);
        //         map.put(rem, map.get(rem)+1);
        //     }
        //     else
        //         map.put(rem, 1);
        // }
        // return count;
        
        //using array
        int[] frq = new int[k];
        int sum=0, count =0;
        frq[0] = 1;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
            int rem = sum%k;
            if(rem < 0) rem += k;
            count += frq[rem];
            frq[rem]++;
        }
        return count;
    }
}