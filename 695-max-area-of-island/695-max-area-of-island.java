class Solution {
    public int helper(int[][] grid, int i, int j, int[] dir){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        int count = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.remove();
            grid[curr[0]][curr[1]] = 0;
            count++;
            for(int k=0 ; k < dir.length ; k+=2){
                i = curr[0] + dir[k]; j = curr[1] + dir[k+1];
                if(i>=0 && j>=0 && i<grid.length && j<grid[0].length){
                    if(grid[i][j] == 1){
                        queue.add(new int[]{i, j});
                        grid[i][j] = 0;
                    }
                }
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0 ;
        int[] dir = new int[]{-1, 0, 0, 1, 1, 0, 0, -1};
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[i].length ; j++){
                if(grid[i][j] == 1)
                    max = Math.max(max, helper(grid, i, j, dir));
            }
        }
        return max;
    }
}