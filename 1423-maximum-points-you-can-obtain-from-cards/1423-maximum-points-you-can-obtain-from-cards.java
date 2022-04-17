class Solution {
    
    
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i=0 ; i<k ; i++)
            sum += cardPoints[i];
        int i=k-1, j=cardPoints.length-1, max = sum, end = cardPoints.length-k-1;
        while(j > end){
            sum -= cardPoints[i];
            sum += cardPoints[j];
            i--; j--;
            max = Math.max(max, sum);
        }
        return max;
    }
}