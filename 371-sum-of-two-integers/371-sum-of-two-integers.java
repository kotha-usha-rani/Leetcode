class Solution {
    public int getSum(int a, int b) {
        int carry = a, sum = b;
        while(carry != 0){
            int tempCarry = carry & sum;
            sum = carry ^ sum;
            carry = tempCarry << 1;
        }
        return sum;
    }
}