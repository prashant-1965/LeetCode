class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        this.dp = new Integer[s.length()][t.length()];
        return dfs(0,0,s,t);
    }
    public int dfs(int idx, int idx2, String s, String t){
        if(idx2==t.length()) return 1;
        if(idx==s.length()) return 0;
        if(dp[idx][idx2]!=null) return dp[idx][idx2];
        int cur=0,next=0;
        if(s.charAt(idx)==t.charAt(idx2)){
            cur += dfs(idx+1,idx2+1,s,t);
        }
        next += dfs(idx+1,idx2,s,t);
        return dp[idx][idx2] = cur+next;
    }
}