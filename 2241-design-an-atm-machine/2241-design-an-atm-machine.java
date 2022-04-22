class ATM {
    long[] atmCount;
    int[] deno;
    public ATM() {
        atmCount = new long[5];
        deno = new int[]{20, 50, 100, 200, 500};
    }
    public void deposit(int[] banknotesCount) {
        for(int i=0 ; i<5 ; i++)
            atmCount[i] += banknotesCount[i];
    }
    public int[] withdraw(int amount) {
        int[] wdCount = new int[5];
        for(int i=4 ; i>=0 ; i--){
            int count = (int)Math.min(atmCount[i], amount/deno[i]);
            wdCount[i] = count;
            amount -= count*deno[i];
        }
        if(amount != 0)
            return new int[]{-1};
        
        for(int i=0 ; i<5 ; i++)
            atmCount[i] -= wdCount[i];
        return wdCount;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */