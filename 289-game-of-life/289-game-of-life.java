class Solution {
    public void gameOfLife(int[][] board) {
        int[] directions = new int[]{-1, -1, -1, 0, -1, 1, 0, 1, 1, 1, 1, 0, 1, -1, 0, -1};
        
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[i].length ; j++){
                int count = 0;
                for(int k=0 ; k<directions.length ; k+=2){
                    int ti = i+directions[k], tj = j+directions[k+1];
                    if(ti>=0 && ti<board.length && tj>=0 && tj<board[i].length){
                        if(board[ti][tj] == 1 || board[ti][tj] == 4 || board[ti][tj] == 5)
                            count += 1 ;
                    }
                }
                if(board[i][j] == 1)
                    board[i][j] = (count<2 || count>3) ? 4 : 5; 
                else
                    board[i][j] = (count == 3) ? 3 : 2;
            }
        }
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[i].length ; j++){
                if(board[i][j] == 2 || board[i][j] == 4)
                    board[i][j] = 0;
                else
                    board[i][j] = 1;
            }
        }
    }
            
}