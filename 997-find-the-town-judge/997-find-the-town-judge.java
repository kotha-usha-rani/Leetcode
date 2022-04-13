class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] graph = new int[n+1][n+1];
        for(int i=0 ; i<trust.length ; i++){
            graph[trust[i][0]][trust[i][1]] = 1;
        }
        for(int i=1 ; i<graph.length ; i++){
            int count = 0 ;
            for(int j=1 ; j<graph.length ; j++){
                if(graph[i][j] == 1)
                    break;
                if(graph[j][i] == 1)
                    count++;
            }
            if(count == n-1)
                return i;
        }
        return -1;
    }
}