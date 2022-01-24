class Solution {
    public int[][] solution(int top, int right, int bottom, int left, int value, int[][] ans){
        if(top > bottom || left > right)
            return ans;
        for(int i=left; i<=right ; i++){
            ans[top][i] = value;
            value++;
        }
         top++;
        for(int i=top ; i<=bottom ; i++){
            ans[i][right] = value;
            value++;
        }
        right--;
        for(int i=right ; i>= left ; i--){
            ans[bottom][i] = value;
            value++;
        }
        bottom--;
        for(int i=bottom ; i>=top ; i--){
            ans[i][left] = value;
            value++;
        }
        left++;
        return solution(top, right, bottom, left, value, ans);
    }
    public int[][] generateMatrix(int n) {
        return solution(0, n-1, n-1, 0, 1, new int[n][n]);
    }
}