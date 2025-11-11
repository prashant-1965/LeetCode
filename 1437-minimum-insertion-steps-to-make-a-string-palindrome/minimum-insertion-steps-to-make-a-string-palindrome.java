class Solution {
    Integer[][] dp;
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        this.dp = new Integer[s.length()][s.length()];
        int len = dfs(0,0,s,t);
        return s.length()-len;
    }
    public int dfs(int idx1, int idx2, String s, String t){
        if(idx1==s.length() || idx2==t.length()) return 0;
        if(dp[idx1][idx2]!=null) return dp[idx1][idx2];
        int take=0;
        if(s.charAt(idx1)==t.charAt(idx2)){
            take = 1+dfs(idx1+1,idx2+1,s,t);
        }
        int skip1 = dfs(idx1+1,idx2,s,t);
        int skip2 = dfs(idx1,idx2+1,s,t);
        return dp[idx1][idx2] = Math.max(take,Math.max(skip1,skip2));
    }
}