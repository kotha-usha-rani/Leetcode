class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<time.length ; i++){
            if(map.containsKey(time[i]))
               map.put(time[i], map.get(time[i])+1);
            else
               map.put(time[i], 1);
        }
        int max = time[0];
        for(int i=1 ; i<time.length ; i++)
            max = Math.max(max, time[i]);
        int count = 0;
        for(int i=0 ; i<time.length ; i++){
            if(map.get(time[i]) > 0){
                int n=1 ;
                map.put(time[i],map.get(time[i])-1);
                while(n*60 - time[i] <= max){
                    if(map.containsKey(n*60 - time[i]) && map.get(n*60 - time[i]) > 0)
                        count += map.get(n*60 - time[i]);
                    n++;
                }
            }
        }
        return count;
    }
}