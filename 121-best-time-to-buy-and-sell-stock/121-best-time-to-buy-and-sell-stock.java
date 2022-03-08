class Solution {
    public int maxProfit(int[] prices) {
        //Method 1: find profit for each stock, return max
        // if(prices.length == 1)
        //     return 0;
        // int max = 0;
        // for(int i=0 ; i<prices.length-1 ; i++){
        //     for(int j=i+1 ; j<prices.length ; j++){
        //         if(prices[i] < prices[j]){
        //             max = Math.max(max, prices[j] - prices[i]);
        //         }
        //     }
        // }
        // return max;
        
        //Method 2 : using two pointer method
        // if(prices.length == 1)
        //     return 0;
        // int left = Integer.MAX_VALUE, right = 0, max=0, i=0;
        // for(; i<prices.length-1 ; i+=2){
        //     if(prices[i] < prices[i+1]){
        //         if(prices[i] < left){
        //             left = prices[i]; 
        //             if(prices[i+1] < right)
        //                 right = 0;
        //         }
        //         if(prices[i+1] > right)
        //             right = prices[i+1];
        //     }
        //     else {
        //         if(prices[i] > right){
        //             right = prices[i];
        //             max = Math.max(max, right-left);
        //         }
        //         if(prices[i+1] < left){
        //             left = prices[i+1];
        //             right = 0;
        //         }
        //     }
        //     if(right != 0)
        //         max = Math.max(max, right-left);
        // }
        // if(i < prices.length){
        //     if(prices[i] > right){
        //         max = Math.max(max, prices[i]-left);
        //     }
        // }
        // return max ;
        
        
        //Method 3: traverse the array to find max profit by updating left min
        if(prices.length == 1)
            return 0;
        int min = prices[0];
        int max = 0;
        for(int i=1 ; i<prices.length ; i++){
            if(prices[i] > min)
                max = Math.max(max, prices[i]-min);
            else
                min = prices[i];
        }
        return max;
    }
}