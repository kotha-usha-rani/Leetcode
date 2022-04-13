class Solution {
    public boolean search(int[][] trust, int i, int j){
        for(int k=0 ; k<trust.length ; k++){
            if(trust[k][0] == i && trust[k][1] == j)
                return true;
        }
        return false;
    }
    public int findJudge(int n, int[][] trust) {
        Stack<Integer> stack = new Stack<>();
        for(int i=1 ; i<=n ; i++)
            stack.push(i);
        while(stack.size() > 1){
            int i = stack.pop();
            int j = stack.pop();
            if(search(trust, i, j))
                stack.push(j);
            else
                stack.push(i);
        }
        int possibleJudge = stack.pop();
        int count = 0;
        for(int i=0 ; i<trust.length ; i++){
            if(trust[i][0] == possibleJudge)
                return -1;
            if(trust[i][1] == possibleJudge)
                count++;
        }
        return (count == n-1) ? possibleJudge : -1;
    }
}