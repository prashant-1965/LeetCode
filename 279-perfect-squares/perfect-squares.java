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
       return dp[i][n] = Math.min(1+dfs(i,n-i*i),dfs(i+1,n));
    }
}