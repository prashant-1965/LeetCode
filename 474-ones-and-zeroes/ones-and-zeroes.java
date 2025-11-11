class Solution {
    Integer[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int one,zero;
        int[][] nums = new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            one=0;zero=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='0') zero++;
                else one++;
            }
            nums[i][0] = zero;
            nums[i][1] = one;
        }
        this.dp = new Integer[nums.length][m+1][n+1];
        return dfs(0,nums,m,n);
    }
    public int dfs(int idx, int[][] nums, int m, int n){
        if(m<0 || n<0) return -601;
        if((m==0 && n==0) || (idx==nums.length && (m>0 || n>0) )) return 0;
        if(idx==nums.length) return -601;
        if(dp[idx][m][n]!=null) return dp[idx][m][n];
        int take = 1+dfs(idx+1,nums,m-nums[idx][0],n-nums[idx][1]);
        if(take<0){
            take =0;
        }
        int skip = dfs(idx+1,nums,m,n);
        return dp[idx][m][n] = Math.max(take,skip);
        
    }
}
// 1 1
// 3 1
// 2 4
// 0 1
// 1 0