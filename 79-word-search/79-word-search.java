class Solution {
    public boolean helper(char[][] board, String word, int index, int i, int j){
        if(index == word.length())
            return true;
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j] != word.charAt(index))
            return false;
        char ch = board[i][j];
        board[i][j] = ' ';
        boolean ans = helper(board, word, index+1, i, j-1)
            || helper(board, word, index+1, i-1, j)
            || helper(board, word, index+1, i, j+1)
            || helper(board, word, index+1, i+1, j);
        
        board[i][j] = ch;
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[i].length ; j++){
                if(board[i][j] == word.charAt(0) && helper(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
}