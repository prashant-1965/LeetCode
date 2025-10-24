class Solution {
    public Integer[] dp;
    public boolean[][] pal;
    public int minCut(String s) {
        this.dp = new Integer[s.length()];
        pal = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                pal[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || pal[i + 1][j - 1]);
            }
        }
        return dfs(0,s);
    }
    public int dfs(int start, String s){
        if(start==s.length()){
            return 0;
        }
        if(dp[start]!=null) return dp[start];
        int val=20001;
        for(int i=start;i<s.length();i++){
            boolean flag = pal[start][i];
            if(flag){
                if(i == s.length() - 1)
                    return dp[start] = 0;
                val = Math.min(val, 1 + dfs(i + 1, s));
            }
        }
        return dp[start]= val;
    }
}