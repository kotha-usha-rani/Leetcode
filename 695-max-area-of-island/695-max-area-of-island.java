class Solution {
    public int helper(int[][] grid, int i, int j, int[] directions){
        if(i<0 || i>= grid.length || j<0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == -1)
            return 0;
            
        int count = 1;
        grid[i][j] = -1;
        for(int k=0 ; k<directions.length ; k+=2){
            count += helper(grid, i+directions[k], j+directions[k+1], directions);
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[] directions = new int[]{-1, 0, 0, 1, 1, 0, 0, -1};
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[i].length ; j++){
                if(grid[i][j] == 1 && grid[i][j] != -1){
                    int ans = helper(grid, i, j, directions);
                    System.out.println(ans);
                    max = Math.max(max, ans);
                }
            }
        }
        return max;
    }
}