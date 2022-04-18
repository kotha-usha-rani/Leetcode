class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for(int c1 = total ; c1 >=0 ; c1-=cost1)
            ans += c1/cost2 + 1;
        return ans;
    }
}