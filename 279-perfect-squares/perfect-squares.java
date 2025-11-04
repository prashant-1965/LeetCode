class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int min = 10001;
            for(int j=1;j*j<=i;j++){
                min = Math.min(min,1+dp[i-j*j]);
            }
            dp[i]=min;
        }
        return dp[n];
    }
}

// class Solution {
//     public Integer[][] dp;
//     public int numSquares(int n) {
//         this.dp = new Integer[(int)Math.floor(Math.sqrt(n))+1][n+1];
//         return dfs(1,n);
//     }
//     public int dfs(int i, int n){
//         if(n==0) return 0;
//         if(n-i*i<0) return 10001;
//         if(dp[i][n]!=null) return dp[i][n];
//        return dp[i][n] = Math.min(1+dfs(i,n-i*i),dfs(i+1,n));
//     }
// }