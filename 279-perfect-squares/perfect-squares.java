class Solution {
    public Integer[][] dp;
    public int numSquares(int n) {
        this.dp = new Integer[(int)Math.floor(Math.sqrt(n))+1][n+1];
        return dfs(1,n);
    }
    public int dfs(int i, int n){
        if(n==0) return 0;
        if(n-i*i<0) return 10001;
        if(dp[i][n]!=null) return dp[i][n];
        int take = dfs(i,n-i*i);
        int skip = dfs(i+1,n);
        int val = Math.min(1+take,skip);
       return dp[i][n] = val;
    }
}