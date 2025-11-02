class Solution {
    public int calculateMinimumHP(int[][] nums) {
        int m = nums.length,n=nums[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = nums[m-1][n-1]<=0?-(nums[m-1][n-1]-1):1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1)continue;
                int val1, val2;
                if(j+1==n){
                    dp[i][j] = Math.max(1,dp[i+1][j]-nums[i][j]);
                }else if(i+1==m){
                    dp[i][j] = Math.max(1,dp[i][j+1]-nums[i][j]);
                }else{
                    val1 = dp[i][j+1]; val2 = dp[i+1][j];
                    if(val1<=0) dp[i][j]=val2-nums[i][j];
                    else if(val2<=0) dp[i][j]=val1-nums[i][j];
                    else{
                        val1 = Math.min(val1,val2)-nums[i][j];
                        dp[i][j] = Math.max(1,val1);
                    }
                }
            }
        }
        return dp[0][0];
    }
}