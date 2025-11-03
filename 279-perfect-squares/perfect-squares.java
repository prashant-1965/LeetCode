class Solution {
    public Integer[][] dp;
    public int numSquares(int n) {
        List<Integer> lt = new ArrayList<>();
        int i=1;
        while(i*i<=n){
            lt.add(i*i);
            i++;
        }
        this.dp = new Integer[lt.size()][n+1];
        return dfs(0,n,lt);
    }
    public int dfs(int idx, int n, List<Integer> lt){
        if(n==0) return 0;
        if(idx==lt.size() ||  n<lt.get(idx)) return 10001;
        if(dp[idx][n]!=null) return dp[idx][n];
        int take = dfs(idx,n-lt.get(idx),lt);
        int skip = dfs(idx+1,n,lt);
        int val = Math.min(1+take,skip);
        // System.out.println(val);
       return dp[idx][n] = val;
    }
}