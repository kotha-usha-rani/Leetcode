class Solution {
    public int getCount(int[][] board, int[][] ans, int i, int j){
        if(i>=0 && i<ans.length && j>=0 && j<ans[i].length)
            return  board[i][j];
        return 0;
    }
    public void gameOfLife(int[][] board) {
        int[][] ans = new int[board.length][board[0].length];
        for(int i=0 ; i<ans.length ; i++){
            for(int j=0 ; j<ans[i].length ; j++){
                ans[i][j] = -1;
            }
        }
        int[] directions = new int[]{-1, -1, -1, 0, -1, 1, 0, 1, 1, 1, 1, 0, 1, -1, 0, -1};
        
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[i].length ; j++){
                int count = 0;
                for(int k=0 ; k<directions.length ; k+=2)
                    count += getCount(board, ans, i+directions[k], j+directions[k+1]);
                if(board[i][j] == 1)
                    ans[i][j] = (count<2 || count>3) ? 0 : 1; 
                else
                    ans[i][j] = (count == 3) ? 1 : 0;
            }
        }
        for(int i=0 ; i<ans.length ; i++){
            for(int j=0 ; j<ans[i].length ; j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}