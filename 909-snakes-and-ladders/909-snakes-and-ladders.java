class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n*n+1];
        boolean[] visited = new boolean[n*n+1];
        queue.add(1);
        distance[1] = 0;
        visited[1] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == n*n){
                return distance[current];
            }
            for(int i=1 ; i<=6 ; i++){
                if((current + i) > n*n)
                    break;
                int row = n-(current+i-1)/n-1;
                int col = (current+i-1)%n;
                if(row%2 == n%2)
                    col = n-(current+i-1)%n-1;
                int square = board[row][col];
                if(board[row][col] == -1)
                    square = current + i;
                if(!visited[square]){
                    visited[square] = true;
                    queue.add(square);
                    distance[square] = distance[current]+1;
                }
            }
        }
        return -1;
    }
}