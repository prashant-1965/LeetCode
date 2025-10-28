class Solution {
    public Set<String> set;
    public Boolean[] dp;
    public boolean wordBreak(String s, List<String> w) {
        this.set = new HashSet<>(w);
        this.dp = new Boolean[s.length()];
        return dfs(0,s);
    }
    public boolean dfs(int idx, String s){
        if(idx==s.length()) return true;
        if(dp[idx]!=null) return dp[idx];
        boolean flag = false;
        for(int i=idx;i<s.length();i++){
            String str = s.substring(idx,i+1);
            if(set.contains(str)){
                flag |= dfs(i+1,s);
            }
        }
        return dp[idx] = flag;
    }
}