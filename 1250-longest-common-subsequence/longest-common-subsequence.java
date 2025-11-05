class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        this.dp = new Integer[s1.length()][s2.length()];
        return dfs(0,0,s1,s2);
    }
    public int dfs(int idx1, int idx2, String s1, String s2){
        if(idx1==s1.length() || idx2==s2.length()) return 0;
        if(dp[idx1][idx2]!=null) return dp[idx1][idx2];
        int val=0;
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            val = 1+dfs(idx1+1,idx2+1,s1,s2);
        }   
        int top = dfs(idx1+1,idx2,s1,s2);
        int down = dfs(idx1,idx2+1,s1,s2);
        return dp[idx1][idx2] = Math.max(val,Math.max(top,down));
    }
}